package es.gabrielferreiro.apps.lavinoteca.controller;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import es.gabrielferreiro.apps.lavinoteca.model.Cliente;
import es.gabrielferreiro.apps.lavinoteca.oldmodel.EstadoPedido;
import es.gabrielferreiro.apps.lavinoteca.model.LineaPedido;
import es.gabrielferreiro.apps.lavinoteca.model.Pedido;
import es.gabrielferreiro.apps.lavinoteca.model.Vino;
import es.gabrielferreiro.apps.lavinoteca.service.ICarritoService;
import es.gabrielferreiro.apps.lavinoteca.service.IClienteService;
import es.gabrielferreiro.apps.lavinoteca.service.IVinoService;

@Controller
@RequestMapping("/carrito/*")
public class CarritoController {

	@Autowired
	IClienteService clienteService;
	
	@Autowired
	IVinoService vinoService;
	
	@Autowired
	ICarritoService carritoService;
	
	public void setVinoService(IVinoService vinoService) {
		this.vinoService = vinoService;
	}

	@RequestMapping("principal")
	public String resumen(HttpSession session) {
		
		// No hay usuario logueado, nos saltamos el listado de compras
		boolean logueado = (Boolean) session.getAttribute("logueado");
		if (!logueado || session.getAttribute("cliente") == null )
			return "/user.jsp";
		
		Cliente cliente = (Cliente) session.getAttribute("cliente");
		List<Pedido> pedidosCliente = cliente.getPedidos();
		
		session.setAttribute("pedidosCliente", pedidosCliente);
		
		return "/user.jsp";
	}
	
	//* MÉTODOS DE MANEJO DEL CARRITO *//
	
	@SuppressWarnings("unchecked")
	@RequestMapping("eliminar")
	public String eliminar(HttpSession session, @RequestParam("id") Integer id) {
		
		// TODO: Comprobar que el carrito no sea null en este punto
		Map<Vino, Integer> carrito = (Map<Vino, Integer>)session.getAttribute("carrito");
		
		Vino vino = vinoService.obtener(id);
		if (vino != null) {
			for (Map.Entry<Vino, Integer> entry : carrito.entrySet()) {
				if (entry.getKey().getId() == vino.getId()) {
					carrito.remove(entry.getKey());
					break;
				}
			}
		}
		
		session.setAttribute("carrito", carrito);
		
		return "forward:principal";
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping("agregar")
	public String agregarPedido(HttpSession session) {
		
		// El usuario no está logueado, no puede realizar pedidos
		if (session.getAttribute("cliente") == null)
			return "principal"; // Debería mostrársele algún aviso del error
		
		Cliente cliente = (Cliente) session.getAttribute("cliente");
		Map<Vino, Integer> carrito = (Map<Vino, Integer>)session.getAttribute("carrito");

		Pedido pedido = new Pedido();
		pedido.setFecha(new Date());
		pedido.setEstado((byte)0);
		pedido.setCliente(cliente);
		pedido.setLineaPedidos(new LinkedList<LineaPedido>());
		
		for (Map.Entry<Vino, Integer> linea : carrito.entrySet()) {
			LineaPedido l = new LineaPedido();
			l.setVino(linea.getKey());
			l.setCantidad(linea.getValue());
			pedido.getLineaPedidos().add(l);
		}
		
		if (cliente.getPedidos() == null) {
			cliente.setPedidos(new LinkedList<Pedido>());
			cliente.getPedidos().add(pedido);
		} else {
			cliente.getPedidos().add(pedido);
		}
		
		carritoService.agregarPedido(pedido);
				
		
		session.setAttribute("cliente", cliente);
		// TODO: Persistir los cambios en la BBDD
		return "forward:principal";
		
	}
	
	//* FIN MÉTODOS DE MANEJO DEL CARRITO *//
	
	//* MÉTODOS DE MANEJO DEL HISTORIAL DE COMPRAS *//
	@RequestMapping(value="pagar", method=RequestMethod.GET)
	public String confirmarPago(HttpSession session, @RequestParam("p") Integer pedidoId){
		
		System.out.println(pedidoId);
		carritoService.confirmarPago(pedidoId);
		Cliente cliente = (Cliente) session.getAttribute("cliente");
		
		for (Pedido p : cliente.getPedidos()) {
			if (p.getId() == pedidoId) {
				p.setEstado((byte)1);
				break;
			}
		}
		
		return "forward:principal";
	}
	
	//* FIN MÉTODOS DE MANEJO DEL HISTORIAL DE COMPRAS *//
}

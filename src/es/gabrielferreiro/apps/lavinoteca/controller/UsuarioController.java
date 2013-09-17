package es.gabrielferreiro.apps.lavinoteca.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import es.gabrielferreiro.apps.lavinoteca.model.Cliente;
import es.gabrielferreiro.apps.lavinoteca.model.Pedido;
import es.gabrielferreiro.apps.lavinoteca.model.Vino;
import es.gabrielferreiro.apps.lavinoteca.service.IClienteService;

@Controller
@RequestMapping("/usuario/*")
public class UsuarioController {

	@Autowired
	IClienteService clienteService;
	
	public void setClienteService(IClienteService clienteService) {
		this.clienteService = clienteService;
	}

	@RequestMapping(value="loguear", method=RequestMethod.POST)
	public String loguear(
			@RequestParam("email") String email, @RequestParam("contrasenha") String contrasenha, HttpSession session) {
		
		// Hay un cliente en sesión, entiendo que viene de un registro
		if (session.getAttribute("cliente") != null)
			return "redirect:/tienda/home/principal";
		
		// No hay cliente en sesión, autenticar
		Cliente cliente = clienteService.obtener(email, contrasenha); // Deberia llamarse autenticar
		
		if (cliente != null) {
			session.setAttribute("cliente", cliente);
			session.setAttribute("logueado", true);
		} else {
			session.setAttribute("logueado", false);
		}
		
		return "redirect:/tienda/home/principal";
	}
	
	@RequestMapping("registro")
	public String formularioRegistrar() {
		return "/register.jsp";
	}
	
	@RequestMapping(value="registrar", method=RequestMethod.POST)
	public String registrar(
			Cliente cliente, HttpSession session) {
		cliente.setFechaNacimiento(new Date());
		clienteService.crear(cliente);
		
		// Logueo al cliente al finalizar el registro
		return loguear(cliente.getCorreo(), cliente.getContrasenha(), session);
		
		// TODO: Localizar de donde viene el usuario y redirigirlo de nuevo
		
		//return "/tienda/home/principal";
	}
	
	@RequestMapping("desloguear")
	public String desloguear(HttpSession session) {
		session.setAttribute("cliente", null);
		session.setAttribute("logueado", null);
		session.setAttribute("carrito", new HashMap<Vino, Integer>());
		session.setAttribute("pedidosCliente", new LinkedList<Pedido>());
		
		return "forward:/tienda/home/principal";
	}
}

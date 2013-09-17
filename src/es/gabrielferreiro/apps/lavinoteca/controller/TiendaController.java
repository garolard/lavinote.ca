package es.gabrielferreiro.apps.lavinoteca.controller;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import es.gabrielferreiro.apps.lavinoteca.model.Vino;
import es.gabrielferreiro.apps.lavinoteca.service.IVinoService;

@Controller
@RequestMapping("/home/*")
public class TiendaController {
	
	@Autowired
	IVinoService vinoService;
	
	public void setVinoService(IVinoService vinoService) {
		this.vinoService = vinoService;
	}

	@RequestMapping("principal")
	public String home(HttpSession session, Model model) {
		List<Vino> novedades = vinoService.obtenerNovedades();
		session.setAttribute("novedades", novedades);
		
		List<Vino> vendidos = vinoService.obtenerVendidos();
		session.setAttribute("vendidos", vendidos);
		
		if (session.getAttribute("carrito") == null) {
			Map<Vino, Integer> carrito = new HashMap<>();
			session.setAttribute("carrito", carrito);
		}
		
		if (session.getAttribute("logueado") == null)
			session.setAttribute("logueado", false);
		
		return "/index.jsp";
	}
	
	@RequestMapping("agregar")
	public String agregar(@RequestParam("id") Integer id, HttpSession session) {
		boolean carritoVacio = false;
		Map<Vino, Integer> carrito = (Map<Vino, Integer>)session.getAttribute("carrito");
		
		if (carrito == null) {
			carrito = new HashMap<Vino, Integer>();
			carritoVacio = true;
		}
		
		if (carrito.size() == 0)
			carritoVacio = true;
		
		Vino target = vinoService.obtener(id);
		
		if (carritoVacio || !carrito.containsKey(target))
			carrito.put(target, 1);
		
		session.setAttribute("carrito", carrito);
		
		return "principal";
	}
	
	@RequestMapping(value="buscar", method=RequestMethod.GET)
	public String buscar(HttpSession session, @RequestParam("query-text") String query) {
		List<Vino> resultados = vinoService.obtenerBusqueda(query);
		
		session.setAttribute("resultados", resultados);
		
		return "/search.jsp";
	}
	
	@RequestMapping(value="categoria", method=RequestMethod.GET)
	public String filtrar(HttpSession session, @RequestParam("cat") Byte categoria) {
		List<Vino> resultados = vinoService.obtenerPorCategoria(categoria);
		
		session.setAttribute("resultados", resultados);
		
		return "/search.jsp";
	}
}

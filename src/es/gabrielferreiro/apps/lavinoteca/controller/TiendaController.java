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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import es.gabrielferreiro.apps.lavinoteca.model.Vino;
import es.gabrielferreiro.apps.lavinoteca.service.IVinoService;

@Controller
public class TiendaController {
	
	@Autowired
	IVinoService vinoService;
	
	@RequestMapping("/home")
	public String home(HttpSession session, Model model) {
		List<Vino> todos = vinoService.obtenerTodos();
		session.setAttribute("todosVinos", todos);
		
		if (session.getAttribute("carrito") == null) {
			Map<Vino, Integer> carrito = new HashMap<>();
			/*carrito.put(todos.get(0), 1);
			carrito.put(todos.get(1), 1);
			carrito.put(todos.get(2), 1);
			carrito.put(todos.get(3), 1);
			carrito.put(todos.get(4), 1);*/
			session.setAttribute("carrito", carrito);
		}
		
		if (session.getAttribute("logueado") == null)
			session.setAttribute("logueado", false);
		
		return "/index.jsp";
	}
	
	@RequestMapping("/home/agregar")
	public String agregar(@RequestParam("id") Integer id, HttpSession session) {
		boolean carritoVacio = false;
		Map<Vino, Integer> carrito = (Map<Vino, Integer>)session.getAttribute("carrito");
		
		if (carrito == null) {
			carrito = new HashMap<>();
			carritoVacio = true;
		}
		
		Vino target = vinoService.obtener(id);
		
		if (carritoVacio || !carrito.containsKey(target))
			carrito.put(target, 1);
		
		return "forward:/tienda/carrito";
	}
}

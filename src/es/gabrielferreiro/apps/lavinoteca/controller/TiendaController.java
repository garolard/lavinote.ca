package es.gabrielferreiro.apps.lavinoteca.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
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
		
		Map<Vino, Integer> carrito = new HashMap<>();
		carrito.put(todos.get(0), 1);
		carrito.put(todos.get(1), 1);
		carrito.put(todos.get(2), 1);
		carrito.put(todos.get(3), 1);
		carrito.put(todos.get(4), 1);
		session.setAttribute("carrito", carrito);
		
		return "/index.jsp";
	}
}

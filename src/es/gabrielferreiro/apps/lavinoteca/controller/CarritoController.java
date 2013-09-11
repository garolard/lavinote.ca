package es.gabrielferreiro.apps.lavinoteca.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import es.gabrielferreiro.apps.lavinoteca.model.Vino;
import es.gabrielferreiro.apps.lavinoteca.service.IVinoService;

@Controller
public class CarritoController {

	@Autowired
	IVinoService vinoService;
	
	@RequestMapping("/carrito")
	public String resumen() {
		return "/user.jsp";
	}
	
	@RequestMapping("/carrito/eliminar")
	public String eliminar(HttpSession session, @RequestParam("id") Integer id) {
		
		Map<Vino, Integer> carrito = (Map<Vino, Integer>)session.getAttribute("carrito");
		
		Vino vino = vinoService.obtener(id);
		if (vino != null)
			carrito.remove(vino);
		
		session.setAttribute("carrito", carrito);
		
		return "redirect:/tienda/carrito";
	}
	
}

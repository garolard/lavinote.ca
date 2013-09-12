package es.gabrielferreiro.apps.lavinoteca.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import es.gabrielferreiro.apps.lavinoteca.model.Cliente;
import es.gabrielferreiro.apps.lavinoteca.service.IClienteService;

@Controller
public class UsuarioController {

	@Autowired
	IClienteService clienteService;
	
	@RequestMapping(value="/usuario/loguear", method=RequestMethod.POST)
	public String loguear(
			@RequestParam("email") String email, @RequestParam("contrasenha") String contrasenha, HttpSession session) {
		
		// Hay un cliente en sesión, entiendo que viene de un registro
		if (session.getAttribute("cliente") != null)
			return "redirect:/tienda/home";
		
		// No hay cliente en sesión, autenticar
		Cliente cliente = clienteService.obtener(email, contrasenha); // Deberia llamarse autenticar
		
		if (cliente != null) {
			session.setAttribute("cliente", cliente);
			session.setAttribute("logueado", true);
		} else {
			session.setAttribute("logueado", false);
		}
		
		return "redirect:/tienda/home";
	}
	
	@RequestMapping("/usuario/registro")
	public String formularioRegistrar() {
		return "/register.jsp";
	}
	
	@RequestMapping(value="/usuario/registrar", method=RequestMethod.POST)
	public String registrar(
			Cliente cliente, HttpSession session) {
		cliente.setId(clienteService.obtenerTodos().size()); // Este ID deberia asignarlo el Dao al crear el objeto
		clienteService.crear(cliente);
		
		// Logueo al cliente al finalizar el registro
		session.setAttribute("cliente", cliente);
		session.setAttribute("logueado", true);
		
		return "redirect:/tienda/home";
	}
	
	@RequestMapping("/usuario/desloguear")
	public String desloguear(HttpSession session) {
		if (session.getAttribute("cliente") != null)
			session.setAttribute("cliente", null);
		session.setAttribute("logueado", false);
		
		return "redirect:/tienda/home";
	}
}

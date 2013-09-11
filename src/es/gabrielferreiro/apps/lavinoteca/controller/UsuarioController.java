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
		Cliente cliente = clienteService.obtener(email, contrasenha); // Deberia llamarse autenticar
		
		if (cliente != null) {
			session.setAttribute("cliente", cliente);
			session.setAttribute("logueado", true);
		} else {
			session.setAttribute("logueado", false);
		}
		
		return "redirect:/tienda/home";
	}
	
}

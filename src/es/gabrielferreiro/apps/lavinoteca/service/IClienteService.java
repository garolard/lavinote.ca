package es.gabrielferreiro.apps.lavinoteca.service;

import java.util.List;

import es.gabrielferreiro.apps.lavinoteca.model.Cliente;

public interface IClienteService {
	public Integer crear(Cliente cliente);
	public Cliente obtener(Integer clave);
	public Cliente obtener(String email, String contrasenha);
	public List<Cliente> obtenerTodos();
}

package es.gabrielferreiro.apps.lavinoteca.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import es.gabrielferreiro.apps.lavinoteca.dao.IClienteDao;
import es.gabrielferreiro.apps.lavinoteca.model.Cliente;

public class ClienteService implements IClienteService {

	@Autowired
	private IClienteDao clienteDao;
	
	public void setClienteDao(IClienteDao clienteDao) {
		this.clienteDao = clienteDao;
	}

	@Override
	public Integer crear(Cliente cliente) {
		return clienteDao.agregar(cliente);
	}

	@Override
	public Cliente obtener(Integer clave) {
		return clienteDao.obtener(clave);
	}

	@Override
	public List<Cliente> obtenerTodos() {
		return clienteDao.obtenerTodos();
	}

	@Override
	public Cliente obtener(String email, String contrasenha) {
		return clienteDao.autenticar(email, contrasenha);
	}

}

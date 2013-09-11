package es.gabrielferreiro.apps.lavinoteca.dao;

import java.util.LinkedList;
import java.util.List;

import es.gabrielferreiro.apps.lavinoteca.model.Cliente;

public class ClienteDao implements IClienteDao {

	private List<Cliente> todosClientes;
	
	{
		todosClientes = new LinkedList<>();
		todosClientes.add(new Cliente("gbril9119@outlook.com", "abc123", "Gabriel", "Ferreiro", "blkasbhuybas"));
	}
	
	@Override
	public Integer agregar(Cliente obj) {
		todosClientes.add(obj);
		return obj.getId();
	}

	@Override
	public void modificar(Cliente obj) {
		// TODO Auto-generated method stub

	}

	@Override
	public void eliminar(Integer clave) {
		
		for (Cliente c : todosClientes) {
			if (c.getId() == clave) {
				todosClientes.remove(c);
				break;
			}
		}
		
	}

	@Override
	public Cliente obtener(Integer clave) {
		
		for (Cliente c : todosClientes) {
			if (c.getId() == clave) {
				return c;
			}
		}
		
		return null;
		
	}

	@Override
	public List<Cliente> obtenerTodos() {
		return todosClientes;
	}

	@Override
	public Cliente autenticar(String correo, String contrasenha) {
		for (Cliente c : todosClientes) {
			if (c.getCorreo().equals(correo) && c.getContrasenha().equals(contrasenha))
				return c;
		}
		return null;
	}

}

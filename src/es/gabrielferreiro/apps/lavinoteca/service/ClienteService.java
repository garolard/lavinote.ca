package es.gabrielferreiro.apps.lavinoteca.service;

import java.util.List;

import javax.persistence.PersistenceException;

import org.springframework.beans.factory.annotation.Autowired;

import es.gabrielferreiro.apps.lavinoteca.dao.IClienteDao;
import es.gabrielferreiro.apps.lavinoteca.dao.IPedidoDao;
import es.gabrielferreiro.apps.lavinoteca.dao.TransactionProxy;
import es.gabrielferreiro.apps.lavinoteca.dao.TransactionProxyFactory;
import es.gabrielferreiro.apps.lavinoteca.model.Cliente;

public class ClienteService implements IClienteService {

	@Autowired
	IClienteDao clienteDao;
	
	@Autowired
	private TransactionProxyFactory transactionProxyFactory;
	
	public void setTransactionProxyFactory(
			TransactionProxyFactory transactionProxyFactory) {
		this.transactionProxyFactory = transactionProxyFactory;
	}

	public void setClienteDao(IClienteDao clienteDao) {
		this.clienteDao = clienteDao;
	}

	@Override
	public void crear(Cliente cliente) {
		TransactionProxy proxy = null;
		
		try {
			proxy = transactionProxyFactory.createTransactionProxy();
			proxy.join(clienteDao);
			
			clienteDao.agregar(cliente);
			
			proxy.commit();
		} catch (PersistenceException e) {
			e.printStackTrace();
			if (proxy != null) {
				try {
					proxy.rollback();
				} catch (PersistenceException e2) {
					e2.printStackTrace();
				}
			}
		}
		
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

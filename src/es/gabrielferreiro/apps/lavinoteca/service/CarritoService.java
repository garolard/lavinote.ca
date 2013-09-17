package es.gabrielferreiro.apps.lavinoteca.service;

import javax.persistence.PersistenceException;

import org.springframework.beans.factory.annotation.Autowired;

import es.gabrielferreiro.apps.lavinoteca.dao.ILineaPedidoDao;
import es.gabrielferreiro.apps.lavinoteca.dao.IPedidoDao;
import es.gabrielferreiro.apps.lavinoteca.dao.TransactionProxy;
import es.gabrielferreiro.apps.lavinoteca.dao.TransactionProxyFactory;
import es.gabrielferreiro.apps.lavinoteca.model.Cliente;
import es.gabrielferreiro.apps.lavinoteca.model.LineaPedido;
import es.gabrielferreiro.apps.lavinoteca.model.Pedido;

public class CarritoService implements ICarritoService {

	public void setTransactionProxyFactory(
			TransactionProxyFactory transactionProxyFactory) {
		this.transactionProxyFactory = transactionProxyFactory;
	}

	@Autowired
	IPedidoDao pedidoDao;
	
	@Autowired
	ILineaPedidoDao lineaPedidoDao;
	
	@Autowired
	TransactionProxyFactory transactionProxyFactory;
	
	@Override
	public Pedido obtenerPedido(Integer pedidoId) {
		return pedidoDao.obtener(pedidoId);
	}
	
	@Override
	public void agregarPedido(Pedido pedido) {
		TransactionProxy proxy = null;
		
		try {
			proxy = transactionProxyFactory.createTransactionProxy();
			proxy.join(pedidoDao);
			proxy.join(lineaPedidoDao);
			
			pedidoDao.agregar(pedido);
			
			for (LineaPedido lp : pedido.getLineaPedidos()) {
				lp.setPedido(pedido);
				lineaPedidoDao.agregar(lp);
			}
			
			proxy.commit();
		} catch (PersistenceException pe) {
			pe.printStackTrace();
			if (proxy != null) {
				try {
					proxy.rollback();
				} catch (PersistenceException e) {
					e.printStackTrace();
				}
			}
		}
		
		proxy.cerrarConexion();
	}

	@Override
	public void confirmarPago(Integer pedidoId) {
		TransactionProxy proxy = null;
		
		try {
			proxy = transactionProxyFactory.createTransactionProxy();
			proxy.join(pedidoDao);
			Pedido target = obtenerPedido(pedidoId);
			target.setEstado((byte)1);
			pedidoDao.modificar(target);
			proxy.commit();
		} catch (PersistenceException pe) {
			pe.printStackTrace();
			if (proxy != null) {
				try {
					proxy.rollback();
				} catch (PersistenceException pe2) {
					pe2.printStackTrace();
				}
			}
		}
		
		
	}

	@Override
	public void cancelarPedido(Integer pedidoId) {
		// TODO Auto-generated method stub

	}
	
	public void setPedidoDao(IPedidoDao pedidoDao) {
		this.pedidoDao = pedidoDao;
	}
	
	public void setLineaPedidoDao(ILineaPedidoDao lineaPedidoDao) {
		this.lineaPedidoDao = lineaPedidoDao;
	}

}

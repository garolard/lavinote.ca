package es.gabrielferreiro.apps.lavinoteca.config;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import es.gabrielferreiro.apps.lavinoteca.dao.ClienteDao;
import es.gabrielferreiro.apps.lavinoteca.dao.IClienteDao;
import es.gabrielferreiro.apps.lavinoteca.dao.ILineaPedidoDao;
import es.gabrielferreiro.apps.lavinoteca.dao.IPedidoDao;
import es.gabrielferreiro.apps.lavinoteca.dao.IVinoDao;
import es.gabrielferreiro.apps.lavinoteca.dao.LineaPedidoDao;
import es.gabrielferreiro.apps.lavinoteca.dao.PedidoDao;
import es.gabrielferreiro.apps.lavinoteca.dao.TransactionProxy;
import es.gabrielferreiro.apps.lavinoteca.dao.TransactionProxyFactory;
import es.gabrielferreiro.apps.lavinoteca.dao.VinoDao;
import es.gabrielferreiro.apps.lavinoteca.service.CarritoService;
import es.gabrielferreiro.apps.lavinoteca.service.ClienteService;
import es.gabrielferreiro.apps.lavinoteca.service.ICarritoService;
import es.gabrielferreiro.apps.lavinoteca.service.IClienteService;
import es.gabrielferreiro.apps.lavinoteca.service.IVinoService;
import es.gabrielferreiro.apps.lavinoteca.service.VinoService;
import es.gabrielferreiro.apps.lavinoteca.service.VinoServiceFactory;

@Configuration
public class Config {

	@Bean
	@Scope("prototype")
	public IVinoDao vinoDao() {
		VinoDao vinoDao = new VinoDao();
		vinoDao.setEntityManagerFactory(entityManagerFactory());
		return vinoDao;
	}
	
	@Bean
	@Scope("prototype")
	public IClienteDao clienteDao() {
		ClienteDao clienteDao = new ClienteDao();
		clienteDao.setEntityManagerFactory(entityManagerFactory());
		return clienteDao;
	}
	
	@Bean
	@Scope("prototype")
	public IPedidoDao pedidoDao() {
		PedidoDao pedidoDao = new PedidoDao();
		pedidoDao.setEntityManagerFactory(entityManagerFactory());
		return pedidoDao;
	}
	
	@Bean
	@Scope("prototype")
	public ILineaPedidoDao lineaPedidoDao() {
		LineaPedidoDao lineaPedidoDao = new LineaPedidoDao();
		lineaPedidoDao.setEntityManagerFactory(entityManagerFactory());
		return lineaPedidoDao;
	}
	
	@Bean
	@Scope("prototype")
	public IVinoService vinoService() {
		return new VinoService();
	}
	
	@Bean
	@Scope("prototype")
	public IClienteService clienteService() {
		return new ClienteService();
	}
	
	@Bean
	@Scope("prototype")
	public ICarritoService carritoService() {
		return new CarritoService();
	}
	
	@Bean
	public EntityManagerFactory entityManagerFactory() {
		return Persistence.createEntityManagerFactory("lavinote.ca-persistence");
	}


	@Bean
	public TransactionProxyFactory transactionProxyFactory() {
		return new TransactionProxyFactory();
	}


	@Bean(initMethod="init")
	@Scope("prototype")
	public TransactionProxy transactionProxy() {
		return new TransactionProxy();
	}
	
}

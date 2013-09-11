package es.gabrielferreiro.apps.lavinoteca.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import es.gabrielferreiro.apps.lavinoteca.dao.ClienteDao;
import es.gabrielferreiro.apps.lavinoteca.dao.IClienteDao;
import es.gabrielferreiro.apps.lavinoteca.dao.IVinoDao;
import es.gabrielferreiro.apps.lavinoteca.dao.VinoDao;
import es.gabrielferreiro.apps.lavinoteca.service.ClienteService;
import es.gabrielferreiro.apps.lavinoteca.service.IClienteService;
import es.gabrielferreiro.apps.lavinoteca.service.IVinoService;
import es.gabrielferreiro.apps.lavinoteca.service.VinoService;

@Configuration
public class Config {

	@Bean
	@Scope("prototype")
	public IVinoDao vinoDao() {
		return new VinoDao();
	}
	
	@Bean
	@Scope("prototype")
	public IClienteDao clienteDao() {
		return new ClienteDao();
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
	
}

package es.gabrielferreiro.apps.lavinoteca.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import es.gabrielferreiro.apps.lavinoteca.dao.IVinoDao;
import es.gabrielferreiro.apps.lavinoteca.dao.VinoDao;
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
	public IVinoService vinoService() {
		return new VinoService();
	}
	
}

package es.gabrielferreiro.apps.lavinoteca.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import es.gabrielferreiro.apps.lavinoteca.dao.IVinoDao;
import es.gabrielferreiro.apps.lavinoteca.dao.VinoDao;
import es.gabrielferreiro.apps.lavinoteca.model.Vino;

public class VinoService implements IVinoService {

	@Autowired
	private IVinoDao vinoDao;
	
	public Vino obtener(Integer vinoId) {
		return vinoDao.obtener(vinoId);
	}
	
	@Override
	public List<Vino> obtenerTodos() {
		return vinoDao.obtenerTodos();
	}
	
	public void setVinoDao(IVinoDao vinoDao) {
		this.vinoDao = vinoDao;
	}

}

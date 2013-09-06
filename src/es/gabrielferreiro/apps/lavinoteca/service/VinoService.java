package es.gabrielferreiro.apps.lavinoteca.service;

import java.util.List;

import es.gabrielferreiro.apps.lavinoteca.dao.VinoDao;
import es.gabrielferreiro.apps.lavinoteca.model.Vino;

class VinoService implements IVinoService {

	private VinoDao dao;
	
	public VinoService() {
		dao = new VinoDao();
	}
	
	@Override
	public List<Vino> obtenerTodos() {
		return dao.obtenerTodos();
	}

}

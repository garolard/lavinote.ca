package es.gabrielferreiro.apps.lavinoteca.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import es.gabrielferreiro.apps.lavinoteca.dao.IVinoDao;
import es.gabrielferreiro.apps.lavinoteca.dao.VinoDao;
import es.gabrielferreiro.apps.lavinoteca.model.Vino;

public class VinoService implements IVinoService {

	@Autowired
	IVinoDao vinoDao;
	
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

	@Override
	public List<Vino> obtenerNovedades() {
		return vinoDao.obtenerNovedades();
	}

	@Override
	public List<Vino> obtenerVendidos() {
		// TODO Auto-generated method stub
		return vinoDao.obtenerVendidos();
	}
	
	public List<Vino> obtenerBusqueda(String busqueda) {
		return vinoDao.obtenerBusqueda(busqueda);
	}
	
	@Override
	public List<Vino> obtenerPorCategoria(Byte idCat) {
		return vinoDao.obtenerPorCategoria(idCat);
	}

}

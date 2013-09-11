package es.gabrielferreiro.apps.lavinoteca.dao;

import java.util.LinkedList;
import java.util.List;

import es.gabrielferreiro.apps.lavinoteca.model.Bodega;

public class BodegaDao implements IBodegaDao {

	private List<Bodega> todasBodegas;
	
	{
		todasBodegas = new LinkedList<>();
		todasBodegas.add(new Bodega("Rodolfo I", "rodolfoi", "clave"));
		todasBodegas.add(new Bodega("Matarromera", "matarro", "clave"));
	}
	
	@Override
	public Integer agregar(Bodega obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void modificar(Bodega obj) {
		// TODO Auto-generated method stub

	}

	@Override
	public void eliminar(Integer clave) {
		// TODO Auto-generated method stub

	}

	@Override
	public Bodega obtener(Integer clave) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Bodega> obtenerTodos() {
		return todasBodegas;
	}

}

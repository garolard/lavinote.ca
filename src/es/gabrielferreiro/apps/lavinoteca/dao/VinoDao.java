package es.gabrielferreiro.apps.lavinoteca.dao;

import java.util.LinkedList;
import java.util.List;

import es.gabrielferreiro.apps.lavinoteca.model.Vino;
import es.gabrielferreiro.apps.lavinoteca.model.VinoCategoria;
import es.gabrielferreiro.apps.lavinoteca.util.Constants;

public class VinoDao implements IVinoDao {

	private List<Vino> todosVinos;
	
	{
		todosVinos = new LinkedList<>();
		for (int i = 0; i < 6; i++) {
			if (i % 2 == 0) {
				todosVinos.add(new Vino("Ferreiro Cepas Vellas", VinoCategoria.TINTO, null,
						"img/wine-stock.jpg"));
			} else {
				todosVinos.add(new Vino("Protos Reserva", VinoCategoria.TINTO, null,
						"img/wine-stock-2.jpg"));
			}
		}
	}
	
	@Override
	public Integer agregar(Vino obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void modificar(Vino obj) {
		// TODO Auto-generated method stub

	}

	@Override
	public void eliminar(Integer clave) {
		// TODO Auto-generated method stub

	}

	@Override
	public Vino obtener(Integer clave) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Vino> obtenerTodos() {
		return todosVinos;
	}

}

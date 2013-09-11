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
			Vino vino = null;
			if (i % 2 == 0) {
				vino = new Vino("Ferreiro Cepas Vellas", VinoCategoria.TINTO, null, 24.99f,
						"img/wine-stock.jpg");
				vino.setId(i);
				todosVinos.add(vino);
			} else {
				vino = new Vino("Protos Reserva", VinoCategoria.TINTO, null, 35.95f,
						"img/wine-stock-2.jpg");
				vino.setId(i);
				todosVinos.add(vino);
			}
		}
	}
	
	@Override
	public Integer agregar(Vino obj) {
		todosVinos.add(obj);
		return obj.getId();
	}

	@Override
	public void modificar(Vino obj) {		
	}

	@Override
	public void eliminar(Integer clave) {
		for (int i = 0; i < todosVinos.size(); i++) {
			Vino v = todosVinos.get(i);
			if (v.getId() == clave) {
				todosVinos.remove(i);
				break;
			}
		}
	}

	@Override
	public Vino obtener(Integer clave) {
		for (Vino v : todosVinos) {
			if (v.getId() == clave) {
				return v;
			}
		}
		return null;
	}

	@Override
	public List<Vino> obtenerTodos() {
		return todosVinos;
	}

}

package es.gabrielferreiro.apps.lavinoteca.service;

import java.util.List;

import es.gabrielferreiro.apps.lavinoteca.model.Vino;

public interface IVinoService {
	public Vino obtener(Integer vinoId);
	public List<Vino> obtenerTodos();
}

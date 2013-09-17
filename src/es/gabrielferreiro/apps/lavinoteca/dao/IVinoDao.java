package es.gabrielferreiro.apps.lavinoteca.dao;

import java.util.List;

import es.gabrielferreiro.apps.lavinoteca.model.Vino;

public interface IVinoDao extends IDao<Vino, Integer> {
	public List<Vino> obtenerNovedades();
	public List<Vino> obtenerVendidos();
	public List<Vino> obtenerBusqueda(String busqueda);
	public List<Vino> obtenerPorCategoria(Byte idCat);
}

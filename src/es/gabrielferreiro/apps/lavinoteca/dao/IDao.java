package es.gabrielferreiro.apps.lavinoteca.dao;

import java.util.List;

public interface IDao<T, K> {
	public K agregar(T obj);
	public void modificar(T obj);
	public void eliminar(K clave);
	public T obtener(K clave);
	public List<T> obtenerTodos();
}

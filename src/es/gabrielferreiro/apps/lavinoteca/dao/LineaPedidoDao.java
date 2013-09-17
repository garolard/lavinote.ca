package es.gabrielferreiro.apps.lavinoteca.dao;

import java.util.List;

import javax.persistence.EntityManager;

import es.gabrielferreiro.apps.lavinoteca.model.LineaPedido;

public class LineaPedidoDao extends BaseDao implements ILineaPedidoDao {

	@Override
	public void agregar(LineaPedido obj) {
		em.persist(obj);
	}

	@Override
	public void modificar(LineaPedido obj) {
		em.merge(obj);
	}

	@Override
	public void eliminar(Integer clave) {
		LineaPedido target = obtener(clave);
		em.remove(target);
	}

	@Override
	public LineaPedido obtener(Integer clave) {
		EntityManager em = this.em;
		if (em == null)
			em = entityManagerFactory.createEntityManager();
		
		return em.find(LineaPedido.class, clave);
	}

	@Override
	public List<LineaPedido> obtenerTodos() {
		EntityManager em = this.em;
		if (em == null)
			em = entityManagerFactory.createEntityManager();
		
		return (List<LineaPedido>) em.createQuery("from LineaPedido").getResultList();
	}

}

package es.gabrielferreiro.apps.lavinoteca.dao;

import java.util.List;

import javax.persistence.EntityManager;

import es.gabrielferreiro.apps.lavinoteca.model.LineaPedido;
import es.gabrielferreiro.apps.lavinoteca.model.Pedido;

public class PedidoDao extends BaseDao implements IPedidoDao {

	@Override
	public void agregar(Pedido obj) {
		em.persist(obj);
	}

	@Override
	public void modificar(Pedido obj) {
		em.merge(obj);
	}

	@Override
	public void eliminar(Integer clave) {
		Pedido target = obtener(clave);
		
		if (target != null)
			em.remove(target);
	}

	@Override
	public Pedido obtener(Integer clave) {
		EntityManager em = this.em;
		if (em == null)
			em = entityManagerFactory.createEntityManager();
		
		return em.find(Pedido.class, clave);
	}

	@Override
	public List<Pedido> obtenerTodos() {
		EntityManager em = this.em;
		if (em == null)
			em = entityManagerFactory.createEntityManager();
		
		return (List<Pedido>) em.createQuery("from Pedido").getResultList();
	}

}

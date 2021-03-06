package es.gabrielferreiro.apps.lavinoteca.dao;

import java.util.List;

import javax.persistence.EntityManager;

import es.gabrielferreiro.apps.lavinoteca.model.Bodega;

public class BodegaDao extends BaseDao implements IBodegaDao {
	
	@Override
	public void agregar(Bodega obj) {
		em.persist(obj);
	}

	@Override
	public void modificar(Bodega obj) {
		em.merge(obj);
	}

	@Override
	public void eliminar(Integer clave) {
		Bodega target = obtener(clave);
		em.remove(target);
	}

	@Override
	public Bodega obtener(Integer clave) {
		EntityManager em = this.em;
		if (em == null)
			em = entityManagerFactory.createEntityManager();
		
		return em.find(Bodega.class, clave);
	}

	@Override
	public List<Bodega> obtenerTodos() {
		EntityManager em = this.em;
		if (em == null)
			em = entityManagerFactory.createEntityManager();
		
		return (List<Bodega>) em.createQuery("from Bodega").getResultList();
	}

}

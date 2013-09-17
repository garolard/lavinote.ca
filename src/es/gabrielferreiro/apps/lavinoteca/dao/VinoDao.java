package es.gabrielferreiro.apps.lavinoteca.dao;

import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import es.gabrielferreiro.apps.lavinoteca.model.Vino;
import es.gabrielferreiro.apps.lavinoteca.oldmodel.VinoCategoria;
import es.gabrielferreiro.apps.lavinoteca.util.Constants;

public class VinoDao extends BaseDao implements IVinoDao {
	
	@Override
	public void agregar(Vino obj) {
		em.persist(obj);
	}

	@Override
	public void modificar(Vino obj) {
		em.merge(obj);
	}

	@Override
	public void eliminar(Integer clave) {
		Vino elemento = obtener(clave);
		if (elemento != null)
			em.remove(elemento);
	}

	@Override
	public Vino obtener(Integer clave) {
		EntityManager em = this.em;
		if (em == null)
			em = entityManagerFactory.createEntityManager();
		
		return em.find(Vino.class, clave);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Vino> obtenerTodos() {
		
		EntityManager em = this.em;
		if (em == null)
			em = entityManagerFactory.createEntityManager();
		
		return (List<Vino>) em.createQuery("from Vino").getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Vino> obtenerNovedades() {
		
		EntityManager em = this.em;
		if (em == null)
			em = entityManagerFactory.createEntityManager();
		
		Query novedadesQuery = em.createQuery("from Vino order by fechaIntroduccion desc");
		
		return (List<Vino>) novedadesQuery.getResultList();
	}

	@Override
	public List<Vino> obtenerVendidos() {
		// TODO: Hacer una MEGA CONSULTA para buscar los vinos más vendidos
		return new LinkedList<>();
	}
	
	@Override
	public List<Vino> obtenerBusqueda(String busqueda) {

		System.out.println(busqueda);
		
		EntityManager em = this.em;
		if (em == null)
			em = entityManagerFactory.createEntityManager();
		
		Query query = em.createQuery("select v from Vino as v inner join v.bodega as b where v.nombre = :busqueda or b.nombre = :busqueda");
		query.setParameter("busqueda", busqueda);
		
		return (List<Vino>) query.getResultList();
		
	}

}

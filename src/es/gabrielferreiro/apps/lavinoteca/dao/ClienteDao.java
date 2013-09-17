package es.gabrielferreiro.apps.lavinoteca.dao;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import es.gabrielferreiro.apps.lavinoteca.model.Cliente;
import es.gabrielferreiro.apps.lavinoteca.model.Vino;

public class ClienteDao extends BaseDao implements IClienteDao {
	
	public ClienteDao() {super();}
	
	@Override
	public void agregar(Cliente obj) {
		EntityManager em = this.em;
		if (em == null)
			em = entityManagerFactory.createEntityManager();
		
		em.persist(obj);
	}

	@Override
	public void modificar(Cliente obj) {
		em.merge(obj);
	}

	@Override
	public void eliminar(Integer clave) {
		
		Cliente elemento = obtener(clave);
		if (elemento != null)
			em.remove(elemento);
		
	}

	@Override
	public Cliente obtener(Integer clave) {
		
		EntityManager em = this.em;
		if (em == null)
			em = entityManagerFactory.createEntityManager();
		
		return em.find(Cliente.class, clave);
		
	}

	@Override
	public List<Cliente> obtenerTodos() {
		EntityManager em = this.em;
		if (em == null)
			em = entityManagerFactory.createEntityManager();
		
		return (List<Cliente>) em.createQuery("from Cliente").getResultList();
	}

	@Override
	public Cliente autenticar(String correo, String contrasenha) {
		EntityManager em = this.em;
		if (em == null)
			em = entityManagerFactory.createEntityManager();
		
		Query q = em.createQuery("from Cliente where correo = :correo and contrasenha = :contrasenha");
		q.setParameter("correo", correo);
		q.setParameter("contrasenha", contrasenha);
		
		Cliente c = (Cliente) q.getSingleResult();
		return c;
	}

}

package es.gabrielferreiro.apps.lavinoteca.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public abstract class BaseDao {

	protected EntityManager em;
	protected EntityManagerFactory entityManagerFactory;	
	protected boolean autoCommit;
	
	public BaseDao(boolean autoCommit) {
		this.autoCommit = autoCommit;
	}
	
	public BaseDao() {
		this(true);
	}
	
	protected void init() {
		if (autoCommit)
			em = entityManagerFactory.createEntityManager();
	}
	
	public boolean isAutoCommit() {
		return this.autoCommit;
	}
	
	public EntityManagerFactory getEntityManagerFactory() {
		return entityManagerFactory;
	}


	public void setEntityManagerFactory(EntityManagerFactory entityManagerFactory) {
		this.entityManagerFactory = entityManagerFactory;
	}


	public EntityManager getEntityManager() {
		return em;
	}


	public void setEntityManager(EntityManager entityManager) {
		this.em = entityManager;
	}

}

package com.github.gherkin.persistence;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;


public abstract class GenericDAO<T>{
	static EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu1");
	
	protected T retrieve(final Class<T> type, Long id) {
		EntityManager em = emf.createEntityManager();
		
		T entity;
		try {
			entity = em.find(type, id);
		} catch(IllegalArgumentException exception) {
			throw exception;
			
		} finally {
			em.close();
		}
		System.out.println("returning entity");

		return entity;
	}
	
	protected Collection<T> retrieveAll(String queryString, Class<T> type) {
		EntityManager em = emf.createEntityManager();
		
		Query query = em.createQuery(queryString, type);
		Collection<T> collection = query.getResultList();
		return collection;
	}
	
	protected void remove(final Class<T> type, Long id) throws Exception {
		EntityManager em = emf.createEntityManager();
		T entity;
		
		EntityTransaction transaction = em.getTransaction();
		try {
			transaction.begin();
			entity = em.find(type, id);
		
		if(entity == null)
			throw new NullPointerException();
		
		em.remove(entity);
		transaction.commit();
		
		} catch(Exception exception) {
			transaction.rollback();
			throw exception;
				
		} finally {
			em.close();
		}

	}

	public void add(T entity) {
		EntityManager em = emf.createEntityManager();
		
		EntityTransaction transaction = em.getTransaction();
		try {
		transaction.begin();
		em.merge(entity);		
		transaction.commit();
		
		} catch(IllegalArgumentException exception) {
			transaction.rollback();
			throw exception;
			
		} finally {
			em.close();
		}
		
	}
}

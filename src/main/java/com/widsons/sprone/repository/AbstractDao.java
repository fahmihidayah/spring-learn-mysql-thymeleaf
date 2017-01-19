package com.widsons.sprone.repository;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;


public abstract class AbstractDao<K extends Serializable, E> {
	private final Class<K> persistentClass;
	
	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	public AbstractDao() {
		this.persistentClass = (Class<K>) ((ParameterizedType) getClass().getGenericSuperclass())
				.getActualTypeArguments()[1];
	}
	
	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	public E findById(K key){
		return (E) getSession().get(persistentClass, key);
	}
	
	public void save(E data){
		getSession().persist(data);
	}
	
	public void delete(E data){
		getSession().delete(data);
	}
	
	public void delete(K id){
		E data = findById(id);
		delete(data);
	}
	
	public List<E> findAll(){
		return createEntityCriteria().list();
	}
	
	public Criteria createEntityCriteria(){
		return getSession().createCriteria(persistentClass);
	}
	
}

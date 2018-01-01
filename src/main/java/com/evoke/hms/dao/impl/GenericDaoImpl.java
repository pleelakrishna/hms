package com.evoke.hms.dao.impl;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.evoke.hms.dao.IGenericDAO;

@Repository
public abstract class GenericDaoImpl<T> implements IGenericDAO<T> {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	GenericDaoImpl(){
		setEntityClass(((Class) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0]));
	}
	
	public Class<T> entityClass;
	
	public Class<T> getEntityClass() {
		return entityClass;
	}
	public void setEntityClass(Class<T> entityClass) {
		this.entityClass = entityClass;
	}
	
	EntityManager entityManager;
	
	@Autowired
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public Session getSession(){
		return entityManager.unwrap(Session.class);
	}
	
	@Override
	public void flushSession(){
		getSession().flush();
	}
	
	@Override
	public void clearSession(){
		getSession().clear();
	}
	
	@Override
	public void add(T entityClass) {
		getSession().save(entityClass);
	}
	
	@Override
	public void saveOrUpdate(T entityClass) {
		Session session = getSession();
		getSession().saveOrUpdate(entityClass);
	}
	
	@Override
	public void update(T entityClass) {
		getSession().update(entityClass);
	}
	
	@Override
	public void delete(T entityClass) {
		getSession().delete(entityClass);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public T get(int id) {
		return (T) getSession().get(entityClass, id);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public T load(int id) {
		return (T) getSession().load(entityClass, id);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public T getByUserName(String userName) {
		return (T) getSession().createQuery("FROM e " + entityClass.getSimpleName() + " WHERE User_Login_Id:=User_Login_Id").setParameter("User_Login_Id", userName);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public T getByHMSId(String hmsId) {
		return (T) getSession().createQuery("FROM " + entityClass.getSimpleName() + " WHERE hmsUniqueId =:hmsUniqueId").setParameter("hmsUniqueId", hmsId).uniqueResult();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<T> get() {
		return getSession().createQuery("FROM " + entityClass.getSimpleName()).setCacheable(true).list();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public T getByNaturalId(String userName){
		return (T) getSession().bySimpleNaturalId(entityClass).load(userName);
	}
	
	@Override
	public Criteria getCriteria(){
		return getSession().createCriteria(entityClass);
	}

}

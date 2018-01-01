package com.evoke.hms.dao;

import java.util.List;

import org.hibernate.Criteria;

public interface IGenericDAO<T> {
	void add(T entityClass);
	void update(T entityClass);
	void delete(T entityClass);
	T get(int id);
	T load(int id);
	T getByUserName(String userName);
	T getByNaturalId(String userName);
	void saveOrUpdate(T entityClass);
	T getByHMSId(String hmsId);
	List<T> get();
	Criteria getCriteria();
	void flushSession();
	void clearSession();
}

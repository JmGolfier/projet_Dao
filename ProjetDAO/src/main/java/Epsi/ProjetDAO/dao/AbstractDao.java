package Epsi.ProjetDAO.dao;

import java.io.Serializable;
import java.util.List;

import Epsi.ProjetDAO.common.HibernateSessionUtils;


public abstract class AbstractDao<T, PK extends Serializable> extends HibernateSessionUtils implements Dao<T, PK> {

	@SuppressWarnings("unchecked")
	public T find(Class<T> c, PK id) {
		return (T) getHibernateTemplate().get(c, id);
	}

	@SuppressWarnings("unchecked")
	public List<T> list(Class<T> c) {
		return getHibernateTemplate().find("from " + c.getCanonicalName());
	}


	@SuppressWarnings("unchecked")
	public PK save(T obj) {
		return (PK) getHibernateTemplate().save(obj);
	}


	public void update(T obj) {
		getHibernateTemplate().update(obj);
	}

	public void delete(T obj) {
		getHibernateTemplate().delete(obj);
	}


}

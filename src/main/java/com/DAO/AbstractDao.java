package com.DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class AbstractDao {

	@Autowired
	private SessionFactory sessionFactory;

	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	public void save(Object entity) {
		getSession().save(entity);
	}

	public void persist(Object entity) {
		getSession().persist(entity);
	}
	
	public void saveOrupdate(Object entity) {
		getSession().saveOrUpdate(entity);;
	}

	public void delete(Object entity) {
		getSession().delete(entity);
	}
}

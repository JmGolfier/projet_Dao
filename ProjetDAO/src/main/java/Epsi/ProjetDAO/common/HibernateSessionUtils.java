package Epsi.ProjetDAO.common;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public abstract class HibernateSessionUtils extends HibernateDaoSupport {

	/**
	 * Hibernate session factory
	 */
	@Autowired
	public void initialize(SessionFactory sessionFactory)
	{
		setSessionFactory(sessionFactory);
	}
}

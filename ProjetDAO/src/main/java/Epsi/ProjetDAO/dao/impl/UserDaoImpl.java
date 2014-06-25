package Epsi.ProjetDAO.dao.impl;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import Epsi.ProjetDAO.dao.AbstractDao;
import Epsi.ProjetDAO.dao.UserDao;
import Epsi.ProjetDAO.entity.User;

@Repository("UserDao")
public class UserDaoImpl extends AbstractDao<User, Long> implements UserDao {

	private static final Logger LOGGER = Logger.getLogger(UserDaoImpl.class);

	public UserDaoImpl() {
		super();
	}

	public User find(Long id) {
		return this.find(User.class, id);
	}

	public User findByName(String name) {
		try{
			return (User) getHibernateTemplate().find("from User u where u.name =?", name).get(0);
		} catch(Exception e){
			LOGGER.error(e.getMessage());
			return null;
		}
	}
}
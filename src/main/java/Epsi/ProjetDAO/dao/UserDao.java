package Epsi.ProjetDAO.dao;

import Epsi.ProjetDAO.entity.User;


public interface UserDao extends Dao<User, Long>{
	public User findByName(String name);

}

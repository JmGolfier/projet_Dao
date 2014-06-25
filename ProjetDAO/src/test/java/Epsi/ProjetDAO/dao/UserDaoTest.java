package Epsi.ProjetDAO.dao;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import Epsi.ProjetDAO.dao.UserDao;
import Epsi.ProjetDAO.entity.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/spring/appContext-test.xml"})
public class UserDaoTest {
	
	@Autowired
	UserDao userDao;
	User manu;
	
	@Test
	public void testList() {
		assertEquals(userDao.list(User.class).size(), 2);
	}
	
	@Test
	public void testFind() {
		manu = userDao.findByName("Manu de la vega");
		assertEquals(manu.getLogin(), "manumanu");
		assertEquals(manu.getPassword(), "password");
		assertEquals(manu.getName(), "Manu de la vega");
	}
	
	@Test
	public void testAdd() {
		User newManu = new User();
		newManu.setName("manuel de la vega");
		newManu.setLogin("manuel d'anglais");
		newManu.setPassword("manuel de maths");
		userDao.save(newManu);
		assertEquals(userDao.findByName("manuel de la vega").getName(), "manuel de la vega");
	}
	
	@Test
	public void testUpdate() {
		manu = userDao.findByName("manuel de la vega");
		manu.setName("manuel d'italien");
		userDao.update(manu);
		assertEquals(userDao.findByName("manuel d'italien").getName(), "manuel d'italien");
	}
	
	@Test
	public void testDelete() {
		User delManu = userDao.findByName("manuel d'italien");
		userDao.delete(delManu);
		assertEquals(userDao.findByName("manuel d'italien"), null);
	}
}

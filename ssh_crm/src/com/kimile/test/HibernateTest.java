package com.kimile.test;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.kimile.dao.UserDao;
import com.kimile.domain.User;
import com.kimile.service.UserService;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class HibernateTest {
	@Resource(name="sessionFactory")
	private SessionFactory sf;
	@Test
	public void fun1() {
		Configuration conf=new Configuration().configure();
		SessionFactory sf=conf.buildSessionFactory();
		Session session=sf.openSession();
		Transaction tx=session.beginTransaction();
		User u=new User();
		u.setUser_code("tom");
		u.setUser_name("tom");
		u.setUser_password("123");
		session.save(u);
		tx.commit();
		session.close();
		sf.close();
	}
	@Test
	public void fun2() {
	
		Session session=sf.openSession();
		Transaction tx=session.beginTransaction();
		User u=new User();
		u.setUser_code("±¦±´¶ùÀÖ¶ù");
		u.setUser_name("»ÄÌÆÐ¡½ã½ã");
		u.setUser_password("123");
		session.save(u);
		tx.commit();
		session.close();
		
	}
	//²âÊÔDao HibernateÄ£°å
	@Resource(name="userDao")
	private UserDao ud;
	@Test
	public void fun3() {
	User u=ud.getByUserCode("ÀÖ¶ù");
	System.out.println(u);
	}
	@Resource(name="userService")
	private UserService us;
	@Test
	public void fun4() {
		User u=new User();
		u.setUser_code("¿Õ½ã");
		u.setUser_name("ÕÔÀöÓ±");
		u.setUser_password("521");
		us.saveUser(u);
	}
}

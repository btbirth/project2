package com.revature.DAOTest;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.revature.beans.Reader;
import com.revature.daos.ReaderDAO;

public class ReaderDAOTest {
	private static ApplicationContext context;
	
	@BeforeClass
	public static void initialize() {
		context = new ClassPathXmlApplicationContext("dao-beans.xml");
	}
	
	@Test
	public void testFindAll() {
		ReaderDAO bean = context.getBean(ReaderDAO.class);
		List<Reader> readers =  bean.findAll();
		System.out.println(readers.get(0));
	}
}

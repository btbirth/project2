package com.revature.DAOTest;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.revature.beans.Article;
import com.revature.beans.Author;
import com.revature.beans.Reader;
import com.revature.daos.AuthorDAO;

public class AuthorDAOTest {
	
private static ApplicationContext context;
private static final Logger LOGGER = Logger.getLogger(AuthorDAOTest.class.getName());

	
	@BeforeClass
	public static void initialize() {
		context = new ClassPathXmlApplicationContext("dao-beans.xml");
	}
	
	@Test
	@Ignore
	public void testFindAll(){
		LOGGER.setLevel(Level.INFO);
		AuthorDAO bean = context.getBean(AuthorDAO.class);
		List<Author> authors =  bean.findAll();
		LOGGER.info(authors.toString());
		
	}
	
	@Test
	@Ignore
	public void testFindOne(){
		AuthorDAO bean = context.getBean(AuthorDAO.class);
		Author author = bean.findByUsername("The Writer");
		//LOGGER.info(author.toString());
	}
	
	@Test
	public void testCreate(){
		Set<Article> articles = new HashSet<Article>();
		Author author = new Author("The Cleaner", "cleanDroppings@gmail.com", "escape", articles);
		AuthorDAO bean = context.getBean(AuthorDAO.class);
		bean.create(author);
		LOGGER.info("I have created an author and have successfully passed the test");
	}
	
	@Test
	@Ignore
	public void testUpdate(){
		AuthorDAO bean = context.getBean(AuthorDAO.class);
		Author author = bean.findById(21);
		author.setEmail("iamliving@gmail.com");
		bean.update(author);
		LOGGER.info("I have updated the Author Bobby, changed his email, and have successfully passed the test");
	}
	
	@Test
	@Ignore
	public void testDelete(){
		AuthorDAO bean = context.getBean(AuthorDAO.class);
		Author author = bean.findById(21);
		bean.delete(author);
		LOGGER.info("Author Bobby has been deleted from the database and successfully passed the test");
	}
	

}

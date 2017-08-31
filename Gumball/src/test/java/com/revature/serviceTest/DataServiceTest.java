package com.revature.serviceTest;

import static org.junit.Assert.assertEquals;

import org.junit.Assert;


import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.HttpStatus;

import com.revature.beans.Article;
import com.revature.beans.Author;
import com.revature.beans.Reader;
import com.revature.daos.ArticleDAO;
import com.revature.daos.AuthorDAO;
import com.revature.daos.ReaderDAO;
import com.revature.service.DataService;


public class DataServiceTest {
	private static ApplicationContext context;
	@BeforeClass
	public static void initialize() {
		context = new ClassPathXmlApplicationContext("dao-beans.xml");
	}
	@Ignore
	@Test
	public void TestCreateAuthor() {
		DataService service = context.getBean(DataService.class);
		Author author = new Author("WriterTwo", "writer@two.com", "password", null);
		service.createAuthor(author);
		AuthorDAO checker = context.getBean(AuthorDAO.class);
		Assert.assertNotNull(checker.findByUsername(author.getUsername()));
		System.out.println("Created");
	}
	
	@Test
	public void TestCreateReader() {
		DataService service = context.getBean(DataService.class);
		Reader reader = new Reader("Dopis", "you@me.com", "madman", "1112224333");
		assertEquals(HttpStatus.CONFLICT, service.createReader(reader.getUsername(),reader.getEmail(),reader.getPassword(),reader.getCreditCardNumber())); 
	}
	@Ignore
	@Test
	public void TestCreateArticle() {
		DataService service = context.getBean(DataService.class);
		AuthorDAO aDAO = context.getBean(AuthorDAO.class);
		Article article = new Article("The niasdfgh is end", "We are asdfall fine, don't worry", aDAO.findById(1), null, null, null);
		service.createArticle(article);
		System.out.println("Created");
	}
}

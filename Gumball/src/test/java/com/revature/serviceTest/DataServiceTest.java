package com.revature.serviceTest;

import org.junit.Assert;


import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

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
	@Ignore
	@Test
	public void TestCreateReader() {
		DataService service = context.getBean(DataService.class);
		Reader reader = new Reader("Dopis", "you@me.com", "madman", "1112224333", null, null);
		service.createReader(reader);
		ReaderDAO checker = context.getBean(ReaderDAO.class);
		Assert.assertNotNull(checker.findByUsername(reader.getUsername()));
		System.out.println("Created");
	}
	@Ignore
	@Test
	public void TestCreateArticle() {
		DataService service = context.getBean(DataService.class);
		AuthorDAO aDAO = context.getBean(AuthorDAO.class);
		Article article = new Article("The nigh is end", "We are all fine, don't worry", aDAO.findById(1), null, null, null);
		service.createArticle(article);
		System.out.println("Created");
	}

}

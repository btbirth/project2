package com.revature.DAOTest;

import java.sql.Blob;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.revature.beans.Article;
import com.revature.beans.Author;
import com.revature.beans.Comment;
import com.revature.beans.Reader;
import com.revature.daos.ArticleDAO;
import com.revature.daos.AuthorDAO;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ArticleDAOTest {

	private static ApplicationContext context;
	private static final Logger LOGGER = Logger.getLogger(AuthorDAOTest.class.getName());
	
	@BeforeClass
	public static void initialize() {
		context = new ClassPathXmlApplicationContext("dao-beans.xml");
	}
	
	@Test
	public void testFindAll(){
		LOGGER.setLevel(Level.INFO);
		ArticleDAO bean = context.getBean(ArticleDAO.class);
		List<Article> artists = bean.findAllArticles();
		LOGGER.info(artists.toString());	
	}
	
	@Test
	public void testFindOne(){
		ArticleDAO bean = context.getBean(ArticleDAO.class);
		Article article = bean.findArticleById(1);
		LOGGER.info(article.toString());
		
	}
	
	@Test
	@Ignore
	public void testCreate(){
		Set<Reader> readers = new HashSet<Reader>();
		Set<Comment> comments = new HashSet<Comment>();
		AuthorDAO author = context.getBean(AuthorDAO.class);
		Article article = new Article("2nd Article fools", "I dont know much about writing but here it goes", author.findById(1),null,readers, comments );
		ArticleDAO bean = context.getBean(ArticleDAO.class);
		bean.create(article);
		LOGGER.info("I have created an article and have successfully passed the test");
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

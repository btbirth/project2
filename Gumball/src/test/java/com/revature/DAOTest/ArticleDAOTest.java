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
	@Ignore
	public void testFindAll(){
		LOGGER.setLevel(Level.INFO);
		ArticleDAO bean = context.getBean(ArticleDAO.class);
		List<Article> artists = bean.findAllArticles();
		LOGGER.info(artists.toString());	
	}
	
	@Test
	@Ignore
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
		ArticleDAO bean = context.getBean(ArticleDAO.class);
		Article article = bean.findArticleById(51);
		article.setTitle("Fresh Prince of Reston");
		bean.update(article);
		LOGGER.info("I have updated the Article, changed the title, and have successfully passed the test");
	}
	
	@Test
	@Ignore
	public void testDelete(){
		ArticleDAO bean = context.getBean(ArticleDAO.class);
		Article article = bean.findArticleById(51);
		bean.delete(article);
		LOGGER.info("An article has been deleted from the database and successfully passed the test");
	}
}

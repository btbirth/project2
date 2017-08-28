package com.revature.DAOTest;

import static org.junit.Assert.assertNull;

import java.util.List;
import java.util.Set;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.revature.beans.Article;
import com.revature.beans.Reader;
import com.revature.daos.ArticleDAO;
import com.revature.daos.ReaderDAO;

public class ReaderDAOTest {
	private static ApplicationContext context;
	
	@BeforeClass
	public static void initialize() {
		context = new ClassPathXmlApplicationContext("dao-beans.xml");
	}
	
	@Ignore
	@Test
	public void testFindAll() {
		ReaderDAO bean = context.getBean(ReaderDAO.class);
		List<Reader> readers =  bean.findAll();
		System.out.println(readers.get(0));
	}
	@Ignore
	@Test
	public void testFindById() {
		ReaderDAO bean = context.getBean(ReaderDAO.class);
		Reader reader = bean.findById(1);
		System.out.println(reader);
	}
	
	
	@Test
	public void testFindByName() {
		ReaderDAO bean = context.getBean(ReaderDAO.class);
		Reader reader = bean.findByUsername("Banops");
		Reader notReader = bean.findByUsername("Userdoesnotexist");
		System.out.println(reader);
		assertNull(notReader);
		System.out.println(notReader);
	}
	
	@Ignore
	@Test
	public void testCreateReader(){	
		ReaderDAO bean = context.getBean(ReaderDAO.class);
		Reader reader = new Reader(((Double)(Math.random()*100)).toString(), ((Double)(Math.random()*10)).toString(), "madman", ((Double)(Math.random()*10)).toString(), null, null);
		reader.setId(1000);
		bean.create(reader);
		
		System.out.println("User Created");
	}
	
	@Ignore
	@Test
	public void testDeleteReader(){
		ReaderDAO bean = context.getBean(ReaderDAO.class);
		Reader reader = new Reader(((Double)(Math.random()*100)).toString(), ((Double)(Math.random()*10)).toString(), "This reader should not be here", ((Double)(Math.random()*10)).toString(), null, null);
		bean.create(reader);
		bean.delete(reader);
		System.out.println("User Deleted");
		
		
	}
	
	@Ignore
	@Test
	public void testUpdateReader(){
		ReaderDAO bean = context.getBean(ReaderDAO.class);
		Reader reader = bean.findById(1);
		reader.setCreditCardNumber(((Double)(Math.random()*100)).toString());
		bean.update(reader);
		System.out.println("User updated");
	}
	@Ignore
	@Test
	public void testSetFavorite() {
		ReaderDAO bean = context.getBean(ReaderDAO.class);
		Reader reader = bean.findById(24);
		
		//get article to favorite
		ArticleDAO articleDAO = context.getBean(ArticleDAO.class);
		Article article = articleDAO.findArticleById(1);
		
		//set and save favorite
		Set<Article> favorites = reader.getFavorites();
		favorites.add(article);
		reader.setFavorites(favorites);
		
		//update reader -> update favorites Table
		bean.update(reader);
		System.out.println("Favorite Added?");
	}
}

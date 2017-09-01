package com.revature.DAOTest;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.revature.beans.Article;
import com.revature.beans.Comment;
import com.revature.beans.Reader;
import com.revature.daos.ArticleDAO;
import com.revature.daos.CommentDAO;
import com.revature.daos.ReaderDAO;

public class CommentDAOTest {
	private static ApplicationContext context;
	
	@BeforeClass
	public static void initialize() {
		context = new ClassPathXmlApplicationContext("dao-beans.xml");
	}
	
	@Ignore
	@Test
	public void testCreate() {
		ArticleDAO articleDAO = context.getBean(ArticleDAO.class);
		Article article = articleDAO.findArticleById(1);
		ReaderDAO readerDAO = context.getBean(ReaderDAO.class);
		Reader reader = readerDAO.findById(1);
		
		CommentDAO commentDAO = context.getBean(CommentDAO.class);
		
		commentDAO.create(new Comment("This is a comment", reader, article));
	}
	
	@Ignore
	@Test
	public void testFindById() {
		CommentDAO commentDAO = context.getBean(CommentDAO.class);
		System.out.println(commentDAO.findById(1));
	}
	@Ignore
	@Test
	public void testUpdateComment(){
		CommentDAO commentDAO = context.getBean(CommentDAO.class);
		Comment comment = commentDAO.findById(1);
		comment.setBody(((Double)(Math.random()*100)).toString());
		commentDAO.update(comment);
	}
	@Ignore
	@Test
	public void testDelete() {
		ArticleDAO articleDAO = context.getBean(ArticleDAO.class);
		Article article = articleDAO.findArticleById(1);
		ReaderDAO readerDAO = context.getBean(ReaderDAO.class);
		Reader reader = readerDAO.findById(1);
		
		CommentDAO commentDAO = context.getBean(CommentDAO.class);
		Comment comment = new Comment("This should not exist", reader, article);
		commentDAO.create(comment);
		commentDAO.Delete(comment);
	}
	
	@Test
	public void testFindAllByArticle() {
		ArticleDAO articleDAO = context.getBean(ArticleDAO.class);
		Article article = articleDAO.findArticleById(1);
		CommentDAO commentDAO = context.getBean(CommentDAO.class);
		List<Comment> comments = commentDAO.findAllByArticle(article);
		System.out.println(comments.size());
		for(int i = 0; i < comments.size() ; i++) {
			System.out.println(comments.get(i));
		}
	}
	
}

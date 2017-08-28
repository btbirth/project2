package com.revature.service;

import static org.hamcrest.CoreMatchers.instanceOf;

import java.util.Set;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import com.revature.beans.Article;
import com.revature.beans.Author;
import com.revature.beans.Comment;
import com.revature.beans.Reader;
import com.revature.daos.ArticleDAO;
import com.revature.daos.AuthorDAO;
import com.revature.daos.CommentDAO;
import com.revature.daos.ReaderDAO;

@Service
public class DataService {
	private static ApplicationContext context = new ClassPathXmlApplicationContext("dao-beans.xml");
	
	public Article viewArticle(Article article) {
		ArticleDAO dao = context.getBean(ArticleDAO.class);
		return dao.findArticleById(article.getId());
	}
	public void createReader(Reader reader) {
		ReaderDAO dao = context.getBean(ReaderDAO.class);
		dao.create(reader);		
	}
	public void createAuthor(Author author) {
		AuthorDAO dao = context.getBean(AuthorDAO.class);
		dao.create(author);
	}
	public void createComment(Comment comment) {
		CommentDAO dao = context.getBean(CommentDAO.class);
		dao.create(comment);
	}
	public void createArticle(Article article) {
		ArticleDAO dao = context.getBean(ArticleDAO.class);
		dao.create(article);
	}
	public void addFavorite(Reader reader, Article article) {
		ReaderDAO dao = context.getBean(ReaderDAO.class);
		Set<Article> favorites = reader.getFavorites();
		favorites.add(article);
		reader.setFavorites(favorites);
		dao.update(reader);
	}
	public void removeFavorite(Reader reader, Article article) {
		ReaderDAO dao = context.getBean(ReaderDAO.class);
		Set<Article> favorites = reader.getFavorites();
		favorites.remove(article);
		reader.setFavorites(favorites);
		dao.update(reader);
	}
}

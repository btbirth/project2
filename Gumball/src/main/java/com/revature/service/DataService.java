package com.revature.service;



import java.util.List;
import java.util.Set;


import org.springframework.beans.BeansException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.revature.beans.Article;
import com.revature.beans.Author;
import com.revature.beans.Comment;
import com.revature.beans.Reader;
import com.revature.daos.ArticleDAO;
import com.revature.daos.AuthorDAO;
import com.revature.daos.CommentDAO;
import com.revature.daos.ReaderDAO;


public class DataService implements ApplicationContextAware {
	
	private ApplicationContext context;
	public void setApplicationContext(ApplicationContext context) throws BeansException {
		this.context = context;
		
	}
	public void createArticle(Article article) {
		ArticleDAO dao = context.getBean(ArticleDAO.class);
		dao.create(article);
	}
	public List<Article> viewAllArticles(){
		ArticleDAO dao = context.getBean(ArticleDAO.class);
		return dao.findAllArticles();
	}
	public List<Article> findAuthorArticles(Author author){
		ArticleDAO dao = context.getBean(ArticleDAO.class);
		return dao.findArticleByAuthor(author);
	}
	public Article viewArticle(Article article) {
		ArticleDAO dao = context.getBean(ArticleDAO.class);
		return dao.findArticleById(article.getId());
	}
	public void updateArticle(Article article) {
		ArticleDAO dao = context.getBean(ArticleDAO.class);
		dao.update(article);
	}
	public void deleteArticle(Article article) {
		ArticleDAO dao = context.getBean(ArticleDAO.class);
		dao.delete(article);
	}
	public HttpStatus createReader(String username, String email, String password, String creditCardNumber) {
		Reader reader = new Reader(username, email, password, creditCardNumber);
		ReaderDAO dao = context.getBean(ReaderDAO.class);	
		try {
			dao.create(reader);
			return HttpStatus.OK;
		}catch(Exception e) {
			return HttpStatus.CONFLICT;
		}
			
	

	}
	public void updateReader(Reader reader) {
		ReaderDAO dao = context.getBean(ReaderDAO.class);
		dao.update(reader);
	}
	public void deleteReader(Reader reader) {
		ReaderDAO dao = context.getBean(ReaderDAO.class);
		dao.delete(reader);
	}
	public void createAuthor(Author author) {
		AuthorDAO dao = context.getBean(AuthorDAO.class);
		dao.create(author);
	}
	public void updateAuthor(Author author) {
		AuthorDAO dao = context.getBean(AuthorDAO.class);
		dao.update(author);
	}
	public void deleteAuthor(Author author) {
		AuthorDAO dao = context.getBean(AuthorDAO.class);
		dao.delete(author);
	}
	public void createComment(Comment comment) {
		CommentDAO dao = context.getBean(CommentDAO.class);
		dao.create(comment);
	}
	public void updateComment(Comment comment) {
		CommentDAO dao = context.getBean(CommentDAO.class);
		dao.update(comment);
	}
	public void deleteComment(Comment comment) {
		CommentDAO dao = context.getBean(CommentDAO.class);
		dao.Delete(comment);
	}

	public Reader addFavorite(Reader user, Article article) {
		ReaderDAO rdao = context.getBean(ReaderDAO.class);
		ArticleDAO adao = context.getBean(ArticleDAO.class);
		Reader reader = rdao.findById(user.getId());
		Article favorite = adao.findArticleById(article.getId());
		Set<Article> favorites = reader.getFavorites();
		favorites.add(favorite);
		reader.setFavorites(favorites);
		rdao.update(reader);
		return reader;
	}
	public void removeFavorite(Reader reader, Article article) {
		ReaderDAO dao = context.getBean(ReaderDAO.class);
		Set<Article> favorites = reader.getFavorites();
		favorites.remove(article);
		reader.setFavorites(favorites);
		dao.update(reader);
	}

}

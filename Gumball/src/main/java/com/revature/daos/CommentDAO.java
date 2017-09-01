package com.revature.daos;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.transaction.annotation.Transactional;

import com.revature.beans.Author;
import com.revature.beans.Comment;
import com.revature.beans.Reader;

public class CommentDAO {
	private SessionFactory sessionFactory;
	
	@Transactional
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	@Transactional	
	public void create(Object comment) {
		sessionFactory.getCurrentSession().save(comment);
	}
	@Transactional
	public Comment findById(int id) {

		return (Comment) sessionFactory.getCurrentSession().createCriteria(Comment.class)
				.add(Restrictions.eq("id", id))
				.list().get(0);
	}
	@Transactional
	public void update(Object comment) {
		sessionFactory.getCurrentSession().update(comment);
		
	}
	@Transactional
	public void Delete(Object comment) {
		sessionFactory.getCurrentSession().delete(comment);
	}
	@SuppressWarnings("unchecked")
	@Transactional
	public List<Comment> findAll(){
		return sessionFactory.getCurrentSession().createQuery("FROM Comment").list();
	}
}

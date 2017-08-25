package com.revature.daos;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import com.revature.beans.Author;


public class AuthorDAO implements DataAccessObject {
	
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		// TODO Auto-generated method stub
		this.sessionFactory = sessionFactory;
	}

	public void create(Object object) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().save(object);
	}

	public void update(Object object) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().saveOrUpdate(object);
	}

	public void delete(Object object) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().delete(object);
	}
	
	public List<Author> findAll(){
		return sessionFactory.getCurrentSession().createQuery("FROM Author").list();
	}
	public Author findById (int id){
		return (Author) sessionFactory.getCurrentSession()
				.createCriteria(Author.class)
				.add(Restrictions.eq("id", id)).list().get(0);
	}
	
	

}

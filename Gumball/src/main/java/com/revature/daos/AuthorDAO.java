package com.revature.daos;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.revature.beans.Author;


public class AuthorDAO{
	
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		// TODO Auto-generated method stub
		this.sessionFactory = sessionFactory;
	}

	@Transactional(isolation=Isolation.READ_COMMITTED, 
			propagation=Propagation.REQUIRED,
			rollbackFor=Exception.class)
	public void create(Object object) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().save(object);
	}

	@Transactional(isolation=Isolation.READ_COMMITTED, 
			propagation=Propagation.REQUIRED,
			rollbackFor=Exception.class)
	public void update(Object object) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().saveOrUpdate(object);
	}

	@Transactional(isolation=Isolation.READ_COMMITTED, 
			propagation=Propagation.REQUIRED,
			rollbackFor=Exception.class)
	public void delete(Object object) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().delete(object);
	}
	
	@SuppressWarnings("unchecked")
	@Transactional
	public List<Author> findAll(){
		return sessionFactory.getCurrentSession().createQuery("FROM Author").list();
	}
	@SuppressWarnings("unchecked")
	@Transactional
	public Author findById (int id){
		return (Author) sessionFactory.getCurrentSession()
				.createCriteria(Author.class)
				.add(Restrictions.eq("id", id)).list().get(0);
	}
	
	

}

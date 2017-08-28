package com.revature.daos;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.FetchMode;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.revature.beans.Reader;

public class ReaderDAO {
	
	private SessionFactory sessionFactory;
	@Transactional
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	@Transactional
	public void create(Object reader) {
		sessionFactory.getCurrentSession().save(reader);
	}
	@Transactional
	public Reader findById(int id) {

		return (Reader) sessionFactory.getCurrentSession().createCriteria(Reader.class)
				.add(Restrictions.eq("id", id))
				.list().get(0);
	}
	@Transactional
	public Reader findByUsername(String username) {
		
		List<Reader> users = sessionFactory.getCurrentSession()
				.createCriteria(Reader.class)
				.add(Restrictions.eq("username", username))
				.list();
		
		if(users.isEmpty()) {
			return null;
		}
		return users.get(0);
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public List<Reader> findAll() {
		
		  return sessionFactory.getCurrentSession()
				  .createQuery("FROM Reader").list();
		 
	}
	@Transactional
	public void update(Object obj) {
		sessionFactory.getCurrentSession().saveOrUpdate(obj);
	}
	@Transactional
	public void delete(Object obj) {
		sessionFactory.getCurrentSession().delete(obj);
	}
//	@Transactional
//	public void setFavorite(int readerId,int articleId) {
//		sessionFactory.getCurrentSession()
//			.createCriteria(arg0)
//	}
	

}

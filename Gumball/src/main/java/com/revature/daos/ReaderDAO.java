package com.revature.daos;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import com.revature.beans.Reader;

public class ReaderDAO implements DataAccessObject{
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}


	public void create(Object reader) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().save(reader);
	}
	
	public Reader findById(int id) {
		
		return (Reader) sessionFactory.getCurrentSession()
				.createCriteria(Reader.class)
					.add(Restrictions.eq("id", id)).list().get(0);
	}
	public List<Reader> findAll(){
		return sessionFactory.getCurrentSession()
				.createQuery("FROM Reader").list();
	}
	public void update(Object obj) {
		// TODO Auto-generated method stub
		
	}

	public void delete(Object obj) {
		// TODO Auto-generated method stub
		
	}

}

package com.revature.daos;

import org.hibernate.SessionFactory;

public interface DataAccessObject {
	
	public void setSessionFactory(SessionFactory sessionFactory);
	public void create(Object obj);
	public void update(Object obj);
	public void delete (Object obj);
	
}

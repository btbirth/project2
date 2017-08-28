package com.revature.service;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.revature.beans.Author;
import com.revature.beans.Reader;
import com.revature.daos.AuthorDAO;
import com.revature.daos.ReaderDAO;

public class BusinessService {
	private static ApplicationContext context = new ClassPathXmlApplicationContext("dao-beans.xml");
	
	
	
	public Author authorValidate(Author author) {
		AuthorDAO aDAO = context.getBean(AuthorDAO.class);
		Author user = aDAO.findByUsername(author.getUsername());
		if(user!=null) {
			if(user.getPassword().equals(author.getPassword())) {
				return user;
			}
		}
		return null;
	}
	public Reader readerValidate(Reader reader) {
		ReaderDAO aDAO = context.getBean(ReaderDAO.class);
		Reader user = aDAO.findByUsername(reader.getUsername());
		if(user!=null) {
			if(user.getPassword().equals(reader.getPassword())) {
				return user;
			}
		}
		return null;
	}
}

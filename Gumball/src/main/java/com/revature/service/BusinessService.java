package com.revature.service;


import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import com.revature.beans.Author;
import com.revature.beans.Reader;
import com.revature.daos.AuthorDAO;
import com.revature.daos.ReaderDAO;

public class BusinessService implements ApplicationContextAware {
	private ApplicationContext context;
	public void setApplicationContext(ApplicationContext context) throws BeansException {
		this.context = context;
		
	}
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

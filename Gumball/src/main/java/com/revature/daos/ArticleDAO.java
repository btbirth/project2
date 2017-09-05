package com.revature.daos;

import java.util.List;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.revature.beans.Article;
import com.revature.beans.Author;
import com.revature.beans.Comment;

public class ArticleDAO {

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory){
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
	public List<Article> findAllArticles(){
		return sessionFactory.getCurrentSession().createQuery("FROM Article").list();
	}
	@SuppressWarnings("unchecked")
	@Transactional
	public Article findArticleById(int id){
		return (Article) sessionFactory.getCurrentSession()
				.createCriteria(Article.class)
				.add(Restrictions.eq("id", id)).list().get(0);
	}
	
	@SuppressWarnings("unchecked")
	@Transactional
	public List<Article> findArticleByAuthor(Author author){
		return  sessionFactory.getCurrentSession()
				.createCriteria(Article.class)
				.add(Restrictions.eq("author", author))
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY)
				.list();
	}
	
	
}

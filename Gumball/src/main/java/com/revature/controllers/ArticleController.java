package com.revature.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.revature.beans.Article;
import com.revature.beans.Author;
import com.revature.daos.ArticleDAO;
import com.revature.service.DataService;

@Controller
public class ArticleController {

	@Autowired
	private ArticleDAO dao;
	@Autowired
	private DataService service;
	
	
	public void setArticleDAO(ArticleDAO dao){
		this.dao = dao;
	}
	
	public void setDataService(DataService service){
		this.service = service;
	}
	
	@RequestMapping(value="/Article/create", method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody // use this to write to response
	public void create(@Valid @RequestBody Article article){
		//service.createArticle(article);
		dao.create(article);
	} //auto converts JSON->object
	
	@RequestMapping(value="/Article/update", method=RequestMethod.PUT, consumes=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody // use this to write to response
	public void update(@Valid @RequestBody Article article){
		service.updateArticle(article);
		//dao.update(article);
	} 
	
	@RequestMapping(value="/Article/delete", method=RequestMethod.DELETE, consumes=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody // use this to write to response
	public void delete(@Valid @RequestBody Article article){
		service.deleteArticle(article);
//		dao.delete(article);
	} 
	
	@RequestMapping(value="/Article/all", method= RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<Article> findAll(){
		//return dao.findAllArticles();
		return service.viewAll();
	}
	
}

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
	private DataService dataService;
	
	public void setDataService(DataService dataService){
		this.dataService = dataService;
	}
	
	
	@RequestMapping(value="/Article/create", method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody // use this to write to response
	public void create(@Valid @RequestBody Article article){
		dataService.createArticle(article);
	} //auto converts JSON->object
	
	@RequestMapping(value="/Article/update", method=RequestMethod.PUT, consumes=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody // use this to write to response
	public void update(@Valid @RequestBody Article article){
		dataService.updateArticle(article);
	} 
	
	@RequestMapping(value="/Article/delete", method=RequestMethod.DELETE, consumes=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody // use this to write to response
	public void delete(@Valid @RequestBody Article article){
		dataService.deleteArticle(article);
	} 
	
	@RequestMapping(value="/Article/all", method= RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<Article> findAll(){
		return dataService.viewAllArticles();
	}
	
	@RequestMapping(value="/Article/findArticle", method= RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Article findArticle(@Valid @RequestBody Article article){
		//return dao.findAllArticles();
		 return dataService.viewArticle(article);
	}
	
}

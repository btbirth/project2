package com.revature.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.revature.beans.Author;
import com.revature.beans.Reader;
import com.revature.daos.AuthorDAO;
import com.revature.daos.ReaderDAO;
import com.revature.service.BusinessService;
import com.revature.service.DataService;

@Controller
//use the @RequestMapping to direct to proper url
public class AuthorController {
	
	@Autowired
	private DataService dataService;
	@Autowired
	private BusinessService businessService;
	@Autowired
	private AuthorDAO dao;
	
	public void setAuthorDAO(AuthorDAO dao){
		this.dao = dao;
	}
	
	
	public void setDataService(DataService dataService) {
		this.dataService = dataService;
	}
	public void setBusinessService(BusinessService businessService) {
		this.businessService = businessService;
	}
	
	
	@RequestMapping(value="/Author/login", method= RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Author login( @Valid @RequestBody Author author, HttpServletRequest req) {
		
		Author user = businessService.authorValidate(author);
		req.getSession().setAttribute("user", user);
		return user;
	}
	
	@RequestMapping(value="/Author/create", method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody // use this to write to response
	public void create(@Valid @RequestBody Author author){
		dataService.createAuthor(author);
	} //auto converts JSON->object
	
	@RequestMapping(value="/Author/update", method=RequestMethod.PUT, consumes=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody // use this to write to response
	public void update(@Valid @RequestBody Author author){
		dataService.updateAuthor(author);
	} 
	
	@RequestMapping(value="/Author/delete", method=RequestMethod.DELETE, consumes=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody // use this to write to response
	public void delete(@Valid @RequestBody Author author){
		dataService.deleteAuthor(author);
	} 
	
	@RequestMapping(value="/Author/all", method= RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<Author> findAll(){
		return dao.findAll();
	}	
	
	@RequestMapping(value="/Author/logout", method= RequestMethod.POST)
	@ResponseBody
	public void logout(HttpServletRequest req) {
		req.getSession().removeAttribute("user");
	}
	
}

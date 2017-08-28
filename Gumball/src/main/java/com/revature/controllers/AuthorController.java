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

import com.revature.beans.Author;
import com.revature.daos.AuthorDAO;

@Controller
//use the @RequestMapping to direct to proper url
public class AuthorController {
	
	@Autowired
	private AuthorDAO dao;
	
	public void setDao(AuthorDAO dao){
		this.dao = dao;
	}
	
	@RequestMapping(value="/Author/create", method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody // use this to write to response
	public void create(@Valid @RequestBody Author author){
		dao.create(author);
	} //auto converts JSON->object
	
	@RequestMapping(value="/Author/update", method=RequestMethod.PUT, consumes=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody // use this to write to response
	public void update(@Valid @RequestBody Author author){
		dao.update(author);
	} 
	
	@RequestMapping(value="/Author/delete", method=RequestMethod.DELETE, consumes=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody // use this to write to response
	public void delete(@Valid @RequestBody Author author){
		dao.delete(author);
	} 
	
	@RequestMapping(value="/Author/all", method= RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<Author> findAll(){
		return dao.findAll();
	}	
	
}

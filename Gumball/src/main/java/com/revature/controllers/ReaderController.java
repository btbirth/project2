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
import com.revature.beans.Reader;
import com.revature.daos.AuthorDAO;
import com.revature.daos.ReaderDAO;

@Controller
public class ReaderController {
	
	@Autowired
	private ReaderDAO dao;
	
	public void setDao(ReaderDAO dao){
		this.dao = dao;
	}
	
	@RequestMapping(value="/Reader/create", method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody // use this to write to response
	public void create(@Valid @RequestBody Reader reader){
		dao.create(reader);
	} //auto converts JSON->object
	
	@RequestMapping(value="/Reader/update", method=RequestMethod.PUT, consumes=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody // use this to write to response
	public void update(@Valid @RequestBody Reader reader){
		dao.update(reader);
	} 
	
	@RequestMapping(value="/Reader/delete", method=RequestMethod.DELETE, consumes=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody // use this to write to response
	public void delete(@Valid @RequestBody Reader reader){
		dao.delete(reader);
	} 
	
	@RequestMapping(value="/Reader/all", method= RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<Reader> findAll(){
		return dao.findAll();
	}	
}

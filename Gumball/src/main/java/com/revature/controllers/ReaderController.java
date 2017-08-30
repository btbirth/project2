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

import com.revature.beans.Reader;

import com.revature.daos.ReaderDAO;
import com.revature.service.BusinessService;
import com.revature.service.DataService;



@Controller

public class ReaderController {
	
	@Autowired
	private DataService dataService;
	@Autowired
	private BusinessService businessService;
	@Autowired
	private ReaderDAO dao;
	
	
	public void setDataService(DataService dataService) {
		this.dataService = dataService;
	}
	public void setBusinessService(BusinessService businessService) {
		this.businessService = businessService;
	}
	public void setDao(ReaderDAO dao){
		this.dao = dao;
	}

	@RequestMapping(value="/Reader/login", method= RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Reader login( @Valid @RequestBody Reader reader, HttpServletRequest req) {
		
		Reader user = businessService.readerValidate(reader);
		req.getSession().setAttribute("user", user);
		return user;
	}
	
	@RequestMapping(value="/Reader/create", method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody // use this to write to response
	public void create(@Valid @RequestBody Reader reader){
		dataService.createReader(reader);
	} //auto converts JSON->object
	
	@RequestMapping(value="/Reader/update", method=RequestMethod.PUT, consumes=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody // use this to write to response
	public void update(@Valid @RequestBody Reader reader){
		dataService.updateReader(reader);
	} 
	
	@RequestMapping(value="/Reader/delete", method=RequestMethod.DELETE, consumes=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody // use this to write to response
	public void delete(@Valid @RequestBody Reader reader){
		dataService.deleteReader(reader);
	} 
	
	@RequestMapping(value="/Reader/all", method= RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<Reader> findAll(){
		return dao.findAll();
	}
	
	@RequestMapping(value="/Reader/logout", method= RequestMethod.POST)
	@ResponseBody
	public void logout(HttpServletRequest req) {
		req.getSession().removeAttribute("user");
	}
}

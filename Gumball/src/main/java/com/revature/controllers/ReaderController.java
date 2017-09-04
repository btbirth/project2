package com.revature.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

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

	@RequestMapping(value="/Reader/login", method=RequestMethod.POST)
	public String login(
			@RequestParam(value = "username", required = false) String username, 
			@RequestParam(value = "password", required = false) String password, 
			HttpServletRequest req)  {
//		String username = req.getParameter("username");
//		String password = req.getParameter("password");
		Reader user = businessService.readerValidate(username, password);
		System.out.println("here");
		if(user != null){
			System.out.println("here");
			req.getSession().setAttribute("user", user);
			return "redirect:/pages/index.html";
		}
		return "redirect:/pages/home.html";
		
	}
	@RequestMapping(value="/Reader/logout", method=RequestMethod.POST)
	public String logout(HttpServletRequest req) {
		req.getSession().invalidate();
		return "redirect:/pages/home.html";
	}
	
	@RequestMapping(value="/Gumball/Reader/create", method=RequestMethod.POST)
	@ResponseBody // use this to write to response
	public ModelAndView create(
			@RequestParam(value="username", required=true) String username, 
			@RequestParam(value="email", required=true) String email, 
			@RequestParam(value="password", required=true) String password, 
			@RequestParam(value="ccn", required=true) String creditCardNumber) 
					throws IOException{
		dataService.createReader(username,email,password,creditCardNumber);
		//resp.sendRedirect("/Gumball/home.html");
		
		//resp.setStatus(dataService.createReader(username,email,password,creditCardNumber).value());
		return new ModelAndView("home");
		//return new ResponseEntity<Object>("",dataService.createReader(username,email,password,creditCardNumber));	
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
	
}
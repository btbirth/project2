package com.revature.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	
	@RequestMapping(value="/Author/login", method= RequestMethod.POST)
	public String login( @RequestParam(value = "username", required = false) String username, 
						 @RequestParam(value = "password", required = false) String password, 
						 HttpServletRequest req) {
		
		Author user = businessService.authorValidate(username, password);
		System.out.println("author loggin in");
		if(user != null){
			System.out.println("not a null user");
			req.getSession().setAttribute("user", user);
			return "redirect:/pages/authorIndex.html";
		}
		return "redirect:/pages/home.html";
	}
	
	@RequestMapping(value="/Author/create", method=RequestMethod.POST)
	@ResponseBody // use this to write to response
	public String create(			
			@RequestParam(value="username", required=true) String username, 
			@RequestParam(value="email", required=true) String email, 
			@RequestParam(value="password", required=true) String password){
		dataService.createAuthor(username, email, BCrypt.hashpw(password, BCrypt.gensalt()));
		return "redirect:/pages/home.html";
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
	public String logout(HttpServletRequest req) {
		req.getSession().removeAttribute("user");
		return "redirect:/pages/home.html";
	}
	
}

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
import com.revature.beans.Comment;
import com.revature.daos.AuthorDAO;
import com.revature.daos.CommentDAO;
import com.revature.service.BusinessService;
import com.revature.service.DataService;

@Controller
public class CommentController {

	@Autowired
	private DataService dataService;
	
	public void setDataService(DataService dataService) {
		this.dataService = dataService;
	}
	
	
	@RequestMapping(value="/Comment/create", method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody // use this to write to response
	public void create(@Valid @RequestBody Comment comment){
		dataService.createComment(comment);
	} //auto converts JSON->object
	
	@RequestMapping(value="/Comment/update", method=RequestMethod.PUT, consumes=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody // use this to write to response
	public void update(@Valid @RequestBody Comment comment){
		dataService.updateComment(comment);
	} 
	
	@RequestMapping(value="/Comment/delete", method=RequestMethod.DELETE, consumes=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody // use this to write to response
	public void delete(@Valid @RequestBody Comment comment){
		dataService.deleteComment(comment);
	} 
	
}

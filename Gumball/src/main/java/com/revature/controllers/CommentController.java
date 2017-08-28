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
import com.revature.daos.CommentDAO;

@Controller
public class CommentController {

	@Autowired
	private CommentDAO dao;
	
	public void setDao(CommentDAO dao){
		this.dao = dao;
	}
	
	@RequestMapping(value="/Comment/create", method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody // use this to write to response
	public void create(@Valid @RequestBody Comment comment){
		dao.create(comment);
	} //auto converts JSON->object
	
	@RequestMapping(value="/Comment/update", method=RequestMethod.PUT, consumes=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody // use this to write to response
	public void update(@Valid @RequestBody Comment comment){
		dao.update(comment);
	} 
	
	@RequestMapping(value="/Comment/delete", method=RequestMethod.DELETE, consumes=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody // use this to write to response
	public void delete(@Valid @RequestBody Comment comment){
		dao.Delete(comment);
	} 
	
}

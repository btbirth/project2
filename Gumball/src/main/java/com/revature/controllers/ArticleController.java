package com.revature.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.revature.beans.Article;
import com.revature.beans.Author;
import com.revature.beans.Reader;
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
	public List<Article> findAll(HttpServletRequest req, HttpServletResponse resp) throws IOException{
		if(req.getSession().getAttribute("user") == null) {
			resp.sendRedirect("/pages/home.html");		
		}	
		return dataService.viewAllArticles();
	}
	@RequestMapping(value="/Article/myArticles", method= RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<Article> findArticles(HttpServletRequest req){
		System.out.println(req.getSession().getAttribute("user"));
		return dataService.findAuthorArticles((Author)req.getSession().getAttribute("user"));
	}
	@RequestMapping(value="/Article/favorites", method= RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<Article> getFavorites(HttpServletRequest req){
		
		Reader reader = (Reader)req.getSession().getAttribute("user");
		List<Article> favorites = new ArrayList<Article>(reader.getFavorites());
		return favorites;
	}
	
	@RequestMapping(value="/Article/findArticle", method= RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Article findArticle(@Valid @RequestBody Article article){
		//return dao.findAllArticles();
		 return dataService.viewArticle(article);
	}
	@RequestMapping(value="/Article/addFavorite", method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<Void> addFavorite(@Valid @RequestBody Article article,HttpServletRequest req){
		
		
		Reader updatedUser = dataService.addFavorite((Reader)req.getSession().getAttribute("user"), article);
		req.getSession().invalidate();
		req.getSession().setAttribute("user", updatedUser);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	@RequestMapping(value="/Article/removeFavorite", method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<Void> removeFavorite(@Valid @RequestBody Article article,HttpServletRequest req){
		dataService.removeFavorite((Reader)req.getSession().getAttribute("user"), article);
		return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
	}
	

}

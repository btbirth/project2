package com.revature.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/")
public class RedirectController {
	@RequestMapping(value="/home", method=RequestMethod.GET)
	public RedirectView redirect(RedirectAttributes attributes) {
		return new RedirectView("home.html");
	}
	
}

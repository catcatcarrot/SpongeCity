package org.boot.city.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {
	
	@RequestMapping("/")
	public String toIndex() {
		return "redirect:/start/index.html";
	}
	
	@RequestMapping("/login")
	public String login() {
		return "forward:/src/views/user/login.html";
	}

}

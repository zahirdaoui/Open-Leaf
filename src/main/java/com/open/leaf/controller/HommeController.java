package com.open.leaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HommeController {
	
	
	@GetMapping
	public String index() {
		return "index";
	}
	
	@GetMapping("home")
	public String home() {
		return "home";
	}


}

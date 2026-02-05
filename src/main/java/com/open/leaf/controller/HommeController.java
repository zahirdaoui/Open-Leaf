package com.open.leaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

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

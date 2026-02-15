package com.open.leaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value ="/public")
public class PublicController {
	@GetMapping("daoui")
	public String index() {
		return "home";
	}
	
	@GetMapping
	public String in() {
		return "home";
	}

}

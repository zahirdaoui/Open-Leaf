package com.open.leaf.controller;

import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HommeController {
	
	
	@GetMapping
	public String index(Locale locale) {
		System.out.println(locale.getLanguage());
		return "index";
	}
	
	@GetMapping("home")
	public String home() {
		return "home";
	}
}

package com.open.leaf.auth;

import org.springframework.security.authentication.BadCredentialsException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.security.authentication.AnonymousAuthenticationToken;

import org.springframework.security.core.Authentication;




import jakarta.validation.Valid;


@Controller
public class AuthController {
	
	private final AuthenticationService authService;
	

	public AuthController(AuthenticationService authService) {
		this.authService = authService;
	}
	
	 
	 @GetMapping("/login")
	 public String login(Model model , Authentication authentication) {
		 
		 model.addAttribute("loginForm" , new LoginForm());
		 
		 if (authentication != null && authentication.isAuthenticated()
		            && !(authentication instanceof AnonymousAuthenticationToken)) {
		        return "redirect:/homepage"; 
		      }
		 
		return "auth/login";
	 }
	 
	 
	 @PostMapping("/login")
	  public String doLogin(@Valid @ModelAttribute LoginForm loginForm, BindingResult bindingResult,  Model model) {
	
		 if(bindingResult.hasErrors()) {
			 return "auth/login";
		 }
	        try {
	        	
	        	authService.login(loginForm);
	        	
	            return "redirect:/test/home";

	        } catch (BadCredentialsException e) {
	        	  model.addAttribute("loginError", "BadCredentials");
	        	  model.addAttribute("loginForm", loginForm);
	        	  return "auth/login";
	        }
	    }
	
}

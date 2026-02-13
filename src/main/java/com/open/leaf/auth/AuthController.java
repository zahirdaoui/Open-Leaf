package com.open.leaf.auth;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;



import jakarta.validation.Valid;


@Controller
public class AuthController {
	
	private AuthenticationService authDao;
	private PasswordEncoder passwordEncoder;

	 @Autowired
	public AuthController(AuthenticationService authDao , PasswordEncoder passwordEncoder) {
		super();
		this.authDao = authDao;
		this.passwordEncoder = passwordEncoder;
	}
	 
	 @GetMapping(value ="login")
	 public String login(Model model) {
		 model.addAttribute("loginForm" , new LoginForm());
		return "auth/login";
	 }
	 
	 @PostMapping(value ="login")
	 public String loginSubmit(@Valid @ModelAttribute LoginForm loginForm , BindingResult bindingResult , Model model) {
		 if(bindingResult.hasErrors()) {
			 return "auth/login";
		 }
		 return "redirect:register";
	 }
	
	@GetMapping()
	public String indexHome() {
		return "index";
	}
	
	@GetMapping("register")
	public String register(Model model) {
		model.addAttribute("registerForm",new RegisterForm());
		return "auth/sign-up";
		
	}
	
	
	/*System.out.println("=====================================================================");
	User user = new User();
	User user1 = new User(3, "daoui", "ezzahir", "daoz@gmail.com", "0625595887", passwordEncoder.encode("123456789"),
			LocalDate.of(1990, 1, 1), true, false, false, null);
	
	user.setId(2);
	user.setFirstName("Alice");
	user.setLastName("Smith");
	user.setEmail("alicexx@dddddexampdle.com");
	user.setPhoneNumber("1155253456789");
	user.setPassword(passwordEncoder.encode("123456789")); // hash your password!
	user.setDateOfBirth(LocalDate.of(1990, 1, 1));
	user.setEnabled(true);
	user.setLocked(false);
	user.setEmailVerified(false);
	user.setProfilePictureUrl(null);
	System.out.println(user.getPassword());
	
	//authDao.register(user1);
	System.out.println("=====================================================================");
	System.out.println("DATA INSERTED UCCESS FULLY");
	System.out.println("=====================================================================");
	*/
}

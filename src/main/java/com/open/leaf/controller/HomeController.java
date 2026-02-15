package com.open.leaf.controller;

import java.util.Locale;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.open.leaf.role.RoleService;
import com.open.leaf.user.User;
import com.open.leaf.user.UserRowMapper;

@Controller
@RequestMapping("/homepage")
public class HomeController {
	
	private JdbcTemplate jdbcTemplate;
	private RoleService roleService;
	
	public HomeController(JdbcTemplate jdbcTemplate , RoleService roleService) {
		
		this.jdbcTemplate = jdbcTemplate;
		this.roleService = roleService;
		
	}

	@GetMapping
	public String index(Locale locale) {
		System.out.println(locale.getLanguage());
		System.out.println("============================================================================");
		try {
            Integer result = jdbcTemplate.queryForObject("SELECT 1", Integer.class);
            System.out.println("✅ DB connected! Result = " + result);
        } catch (Exception e) {
            System.out.println("❌ DB connection failed!");
            e.printStackTrace();
        }
		return "index";
	}
	
	@GetMapping("home")
	public String home() {
		
		User  user= new User();
		System.out.println("===================================bbbbbbbbbbbbbbbbbbbbbbbb=========================================");
		user = jdbcTemplate.queryForObject("SELECT id , email , password FROM users WHERE email=?",new UserRowMapper(),"daoz@gmail.com");
		System.out.println("==================================bbbbbbbbbbbbbbbb==========================================");
		System.out.println(user);

		System.out.println("============================================================================");
		return "index";
	}
}

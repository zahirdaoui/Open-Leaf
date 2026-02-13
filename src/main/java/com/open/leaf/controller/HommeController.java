package com.open.leaf.controller;

import java.util.Locale;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.open.leaf.role.RoleService;

@Controller
@RequestMapping(value ="test")
public class HommeController {
	
	private JdbcTemplate jdbcTemplate;
	private RoleService roleService;
	
	public HommeController(JdbcTemplate jdbcTemplate , RoleService roleService) {
		
		this.jdbcTemplate = jdbcTemplate;
		this.roleService = roleService;
		
	}

	@GetMapping
	public String index(Locale locale) {
		System.out.println(locale.getLanguage());
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
		System.out.println("============================================================================");
		System.out.println(roleService.getRoleByName("ADMIN"));

		System.out.println("============================================================================");
		return "auth/sign-in";
	}
}

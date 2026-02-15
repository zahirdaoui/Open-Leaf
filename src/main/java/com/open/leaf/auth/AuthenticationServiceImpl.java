package com.open.leaf.auth;

import java.security.Timestamp;
import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.rememberme.TokenBasedRememberMeServices;
import org.springframework.stereotype.Service;
 


import com.open.leaf.user.User;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {
	
	private final  JdbcTemplate jdbcTemplate;
	
	private final PasswordEncoder passwordEncoder;

	private final AuthenticationManager authenticationManager;
	private final HttpServletRequest request;
	private final HttpServletResponse response;
	
	@Autowired
	private TokenBasedRememberMeServices rememberMeServices;
	

	public AuthenticationServiceImpl(JdbcTemplate jdbcTemplate,PasswordEncoder passwordEncoder , AuthenticationManager authenticationManager,
			HttpServletRequest request,HttpServletResponse response) {
		
		   this.jdbcTemplate = jdbcTemplate;
		   this.passwordEncoder = passwordEncoder;
		   this.authenticationManager = authenticationManager;
		   this.request = request;
		   this.response = response;
	}

	@Override
	public User login(LoginForm loginForm) {
		
		System.out.println("welcome in aithservice from controller ");
		
		Authentication authentication =
                authenticationManager.authenticate(
                        new UsernamePasswordAuthenticationToken(loginForm.getEmail(), loginForm.getPassword())
                );

        SecurityContextHolder.getContext().setAuthentication(authentication);
        request.getSession(true)
               .setAttribute("SPRING_SECURITY_CONTEXT", SecurityContextHolder.getContext());
     
        System.out.println("AUTH = " + authentication);
        System.out.println("SESSION ID = " + request.getSession().getId());
       
        
        rememberMeServices.loginSuccess(request, response, authentication);
        
        final User user = (User) authentication.getPrincipal();

        return user;
        
	}

	@Override
	public void register(User user) {
		 String sql = "INSERT INTO public.users ("
	                + "id, first_name, last_name, email, phone_number, password, "
	                + "date_of_birth, enabled, locked, email_verified, profile_picture_url"
	                + ") VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

	        jdbcTemplate.update(sql,
	                user.getId(),
	                user.getFirstName(),
	                user.getLastName(),
	                user.getEmail(),
	                user.getPhoneNumber(),
	                user.getPassword(),                      // hash password in production!
	                user.getDateOfBirth() != null 
	                        ? Date.valueOf(user.getDateOfBirth()) 
	                        : null,                          // LocalDate → java.sql.Date
	                user.isEnabled(),
	                user.isLocked(),
	                user.isEmailVerified(),
	                user.getProfilePictureUrl()
	        );
		
		
	}

}

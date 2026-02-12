package com.open.leaf.auth;

import java.security.Timestamp;
import java.sql.Date;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
 


import com.open.leaf.user.User;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {
	
	private JdbcTemplate jdbcTemplate;
	

	public AuthenticationServiceImpl(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public User login(User user) {
		
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

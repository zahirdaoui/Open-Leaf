package com.open.leaf.security;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

public class SecurityConfig {
	
	private String[] STATIC_REAOURCES = {
	        "/css/**",
	        "/js/**",
	        "/images/**",
	        "/assets/**",
	        "/webjars/**"
	    };
	
	
	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
	    http
	        .csrf(csrf -> csrf.disable())
	        .authorizeHttpRequests(auth -> auth
	            .requestMatchers(this.STATIC_REAOURCES).permitAll()
	            .requestMatchers("/login","public/**").permitAll()
	            .requestMatchers("admin/**").hasAnyRole("ADMIN","USER")
	            .requestMatchers("user/**").hasRole("USER")
	            .anyRequest().authenticated()
	        )
	        .formLogin(form -> form.permitAll());

	    return http.build();
	}
	
	
	@Bean
	public UserDetailsService users() {
	    return new InMemoryUserDetailsManager(
	        User.withUsername("admin")
	            .password("{noop}admin123")
	            .roles("ADMIN")
	            .build(),
	        User.withUsername("user")
	            .password("{noop}user123")
	            .roles("USER")
	            .build()
	    );
	}

}

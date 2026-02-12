package com.open.leaf.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.open.leaf.user.UserService;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	@Autowired
	private UserService userService;
	
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
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	 // 2.DaoAuthenticationProvider using your CustomUserDetailService
    @Bean
    public DaoAuthenticationProvider authenticationProvider(
            UserService userService,
            PasswordEncoder passwordEncoder) {
    	
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(userService);
        provider.setPasswordEncoder(passwordEncoder);
        return provider;
    }
    
    //3.AuthenticationManager with your provider
    @Bean
    public AuthenticationManager authenticationManager(DaoAuthenticationProvider authProvider) {
        return new ProviderManager(authProvider);
    }


}

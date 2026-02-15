package com.open.leaf.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.RememberMeServices;
import org.springframework.security.web.authentication.rememberme.TokenBasedRememberMeServices;

import com.open.leaf.user.UserService;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	@Autowired
	private UserService userDetailsService;

	private final String[] STATIC_RESOURCES = {
		    "/resources/css/**",
		    "/resources/js/**",
		    "/resources/images/**",
		    "/resources/assets/**",
		    "/resources/webjars/**"
		};

    // ---------------- Password Encoder ----------------
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // ---------------- Authentication Provider ----------------
    @Bean
    public AuthenticationProvider authenticationProvider(UserService userDetailsService,
                                                         PasswordEncoder passwordEncoder) {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider(passwordEncoder);
        provider.setUserDetailsService(userDetailsService);
        return provider;
    }

    // ---------------- Authentication Manager ----------------
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationProvider authProvider) {
        return new ProviderManager(authProvider);
    }

    // ---------------- Remember-Me Services ----------------
  /*  @Bean
    public RememberMeServices rememberMeServices(UserService userDetailsService) {
        return new TokenBasedRememberMeServices(
                "openleaf-remember-me-key",
                userDetailsService
        );
    }*/
    @Bean
    public TokenBasedRememberMeServices rememberMeServices(
            UserService userDetailsService) {

        return new TokenBasedRememberMeServices(
                "openleaf-remember-me-key",
                userDetailsService
        );
    }
   

    // ---------------- Security Filter Chain ----------------
    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http,TokenBasedRememberMeServices rememberMeServices) throws Exception {
        http
            .authorizeHttpRequests(auth -> auth
                .requestMatchers(STATIC_RESOURCES).permitAll()
                .requestMatchers("/login", "/public/**").permitAll()
                .requestMatchers("/admin/**","/homepage/**").hasAuthority("ADMIN")
                .requestMatchers("/user/**").hasAuthority("USER")
                .anyRequest().authenticated()
                
            ).logout(logout -> logout
                    .logoutUrl("/logout")                 // POST /logout
                    .logoutSuccessUrl("/login?logout")   // بعد الخروج
                    .invalidateHttpSession(true)         // حذف الـ session
                    .deleteCookies("JSESSIONID", "remember-me") // حذف الكوكيز
                    .permitAll()
                )
            .rememberMe(remember -> remember
                    .rememberMeServices(rememberMeServices)
                )
            .sessionManagement(session -> session
                .sessionFixation().migrateSession()
            );
//.requestMatchers("/test/**").authenticated()
        return http.build();
    }

}

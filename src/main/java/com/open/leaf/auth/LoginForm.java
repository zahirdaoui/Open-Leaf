package com.open.leaf.auth;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;


public class LoginForm {
	
	@NotBlank(message = "{login.email.required}")
	@Pattern(
	        regexp = "^(?:[a-zA-Z0-9._-]{3,30}|[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+)$",
	        message = "{login.email.invalid}"
	    )
	private String email; 

    @NotBlank(message = "{login.password.required}")
    private String password;
    
    
    
 
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}

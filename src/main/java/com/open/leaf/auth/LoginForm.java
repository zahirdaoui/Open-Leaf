package com.open.leaf.auth;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;


public class LoginForm {
	
	@NotBlank(message = "{login.identifier.required}")
	@Pattern(
	        regexp = "^(?:[a-zA-Z0-9._-]{3,30}|[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+)$",
	        message = "{login.identifier.invalid}"
	    )
	private String identifier; // username OR email

    @NotBlank(message = "{login.password.required}")
    private String password;
    
 
    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}

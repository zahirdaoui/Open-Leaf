package com.open.leaf.auth;

import com.open.leaf.user.User;

public interface AuthenticationService {
	
	    User login(LoginForm loginForm);

	    void register(User user);

}

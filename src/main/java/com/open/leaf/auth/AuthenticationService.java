package com.open.leaf.auth;

import com.open.leaf.user.User;

public interface AuthenticationService {
	
	    User login(User user);

	    void register(User user);

}

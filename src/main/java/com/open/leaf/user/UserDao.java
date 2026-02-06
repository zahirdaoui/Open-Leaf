package com.open.leaf.user;

import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserDao  extends UserDetailsService{
	
	
    void updateProfileInfo(User user, String userId);

    void changePassword(User user, String userId);

    void deactivateAccount(String userId);

    void reactivateAccount(String userId);

    void deleteAccount(String userId);

}
package com.open.leaf.user;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;


public class UserServiceImp implements UserService  {

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateProfileInfo(User user, String userId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void changePassword(User user, String userId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deactivateAccount(String userId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void reactivateAccount(String userId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAccount(String userId) {
		// TODO Auto-generated method stub
		
	}


}

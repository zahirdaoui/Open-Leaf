package com.open.leaf.user;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImp implements UserService  {
	
	private JdbcTemplate jdbctemplate;
	

	public UserServiceImp(JdbcTemplate jdbctemplate) {
		this.jdbctemplate = jdbctemplate;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		String sql = "SELECT username, password FROM public.users WHERE username = ?";
		User user;
		 try {
	           user= jdbctemplate.queryForObject(sql, new Object[]{username},new UserRowMapper());
	        } catch (Exception e) {
	            throw new UsernameNotFoundException("User not found: " + username);
	        }
		 return user;
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

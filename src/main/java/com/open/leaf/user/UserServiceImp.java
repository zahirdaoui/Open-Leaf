package com.open.leaf.user;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.open.leaf.user.mapper.UserLoginMapper;

@Service
public class UserServiceImp implements UserService  {
	
	private JdbcTemplate jdbctemplate;
	

	public UserServiceImp(JdbcTemplate jdbctemplate) {
		this.jdbctemplate = jdbctemplate;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User user;
		 try {
			    String sql = "SELECT id , email , password , enabled FROM public.users WHERE email = ?";
	            user= jdbctemplate.queryForObject(sql,new UserLoginMapper(),username);
	        } catch (Exception e) {
	            throw new UsernameNotFoundException("User not found: " + username);
	        }
		 System.out.println("User enabled: " + user.isEnabled());

		 List<String> roles = jdbctemplate.query(
				    "SELECT r.name FROM \"public\".\"roles\" r " +
				    "JOIN \"public\".\"user_roles\" ur ON ur.role_id = r.id " +
				    "WHERE ur.user_id = ?",
				    new Object[]{user.getId()},
				    (rs, rowNum) -> rs.getString("name")
				);
		 System.out.println("userId = " + user.getId());
		 List<SimpleGrantedAuthority> authorities = roles.stream()
	                .map(SimpleGrantedAuthority::new)
	                .toList();
		 user.setAuthorities(authorities);
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

package com.open.leaf.role;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;


@Service
public class RoleServiceImp implements RoleService {
	
	private JdbcTemplate jdbcTemplate;

    public RoleServiceImp() {
	
	}

    @Autowired
	public RoleServiceImp(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
    
	@Override
	public Role getRoleByName(String name) {
		
			Role role = new Role();
			String sql = "SELECT id , name FROM public.roles WHERE name = ?";
			role = jdbcTemplate.queryForObject(sql, new RoleMapper(), name);
			return role;
	}

	@Override
	public List<Role> getRoleByUser(Integer user_id) {
		
		String sql = "SELECT roles.id , roles.name FROM"
					+"roles INNER JOIN user_roles ON roles.id = user_roles.role_id"
					+" WHERE user_roles.user_id = ?";
		List<Role> roles = jdbcTemplate.query(sql, new RoleMapper(), user_id);
		
		return roles;
	}

	
}

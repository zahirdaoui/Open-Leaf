package com.open.leaf.role;

import java.util.List;

public interface RoleService {
	
	
	public Role getRoleByName(String name);
	
	public List<Role> getRoleByUser(Integer user_id);
	
	
}

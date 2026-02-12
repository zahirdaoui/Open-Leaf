package com.open.leaf.role;

import java.util.List;

import com.open.leaf.user.User;



public class Role {
	
	private Integer id;
	private String name;
	private List<User> user;
	
	public Role() {
	}

	public Role(Integer id, String name, List<User> user) {
		super();
		this.id = id;
		this.name = name;
		this.user = user;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<User> getUser() {
		return user;
	}

	public void setUser(List<User> user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Role [id=" + id + ", name=" + name + ", user=" + user + "]";
	}
	
	
}

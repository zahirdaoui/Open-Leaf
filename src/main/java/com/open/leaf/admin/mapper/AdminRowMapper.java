package com.open.leaf.admin.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.open.leaf.admin.entity.Admin;

public class AdminRowMapper implements RowMapper<Admin> {

	@Override
	public Admin mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		return new Admin();
	}
}

package com.open.leaf.user;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.jdbc.core.RowMapper;

public class UserRowMapper implements RowMapper<User> {

	@Override
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		User user = new User();
		user.setId(rs.getString("id"));
		user.setFirstName(rs.getString("firstName"));
		user.setLastName(rs.getString("lastName"));
		user.setEmail(rs.getString("email"));
		user.setPhoneNumber(rs.getString("phoneNumber"));
		user.setPassword(rs.getString("password"));
		user.setPassword(rs.getString("password"));
        user.setDateOfBirth(rs.getObject("date_of_birth", LocalDate.class));
        user.setEnabled(rs.getBoolean("enabled"));
        user.setLocked(rs.getBoolean("locked"));
        user.setCredentialsExpired(rs.getBoolean("credentials_expired"));
        user.setEmailVerified(rs.getBoolean("email_verified"));
        user.setProfilePictureUrl(rs.getString("profile_picture_url"));
        user.setPhoneVerified(rs.getBoolean("phone_verified"));
        user.setCreatedDate(rs.getObject("created_date", LocalDateTime.class));
        user.setLastModifiedDate(rs.getObject("last_modified_date", LocalDateTime.class));
		return user;
	}

}

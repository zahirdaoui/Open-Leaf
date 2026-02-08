package com.open.leaf.user.validator;

import jakarta.validation.constraints.NotEmpty;

public class InsertUserForm {
	
	@NotEmpty(message ="the name most be not null")
	private String firstName;

}

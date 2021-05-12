package com.bank.model;

import javax.validation.constraints.NotBlank;

public class Login {
	
	@NotBlank(message="Must Not Be Empty")
	private String username;
	@NotBlank(message="Must Not Ee Empty")
	private String password;

	public String getUsername() {
		return username;
	}

	public void setUsername(String userName) {
		this.username = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	

}

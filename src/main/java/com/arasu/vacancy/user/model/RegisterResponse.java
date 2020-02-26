package com.arasu.vacancy.user.model;


import com.arasu.vacancy.entity.User;

public class RegisterResponse {
	private boolean isSuccess;
	private String message;
	private String token;
	private User user;
	
	
	public RegisterResponse() {
	}
	public RegisterResponse(boolean isSuccess, String message, User user, String token) {
		super();
		this.isSuccess = isSuccess;
		this.message = message;
		this.user = user;
		this.token = token;
	}
	public boolean isSuccess() {
		return isSuccess;
	}
	public void setSuccess(boolean isSuccess) {
		this.isSuccess = isSuccess;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
}

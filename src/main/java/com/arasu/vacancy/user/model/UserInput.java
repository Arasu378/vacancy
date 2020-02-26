package com.arasu.vacancy.user.model;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "All details about the User. ")
public class UserInput {
	@ApiModelProperty(notes = "First Name", required = true)
	private String firstName;
	
	@ApiModelProperty(notes = "Last Name", required = false)
	private String lastName;
	
	@ApiModelProperty(notes = "Email", required = true)
	private String email;
	
	@ApiModelProperty(notes = "STG-ID", required = true)
	private Integer stgId;
	
	@ApiModelProperty(notes = "Role", required = true)
	private String role;
	
	@ApiModelProperty(notes = "Password")
	private String password;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getStgId() {
		return stgId;
	}

	public void setStgId(Integer stgId) {
		this.stgId = stgId;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	
	
	
	
	
}

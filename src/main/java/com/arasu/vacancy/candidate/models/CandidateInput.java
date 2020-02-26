package com.arasu.vacancy.candidate.models;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "All details about the Candidate. ")
public class CandidateInput {
	
	@ApiModelProperty(notes = "Candidate Preferred Time", required = true)
	private String candidatePreferredTime;
	
	@ApiModelProperty(notes = "Candidate Email", required = true)
	private String candidateEmail;
	
	@ApiModelProperty(notes = "Candidate First Name", required = true)
	private String firstName;
	
	@ApiModelProperty(notes = "Candidate Last Name", required = false)
	private String lastName;
	
	@ApiModelProperty(notes = "Is Candidate a Senior", required = true)
	private boolean isSenior;
	
	@ApiModelProperty(notes = "Candidate Mobile", required = false)
	private String candidateMobile;
	
	@ApiModelProperty(notes = "Years of experience", required = true)
	private Integer yearsOfExperience;
	
	@ApiModelProperty(notes = "User Id", required = true)
	private Integer userId;
	public String getCandidatePreferredTime() {
		return candidatePreferredTime;
	}
	public void setCandidatePreferredTime(String candidatePreferredTime) {
		this.candidatePreferredTime = candidatePreferredTime;
	}
	public String getCandidateEmail() {
		return candidateEmail;
	}
	public void setCandidateEmail(String candidateEmail) {
		this.candidateEmail = candidateEmail;
	}
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
	public boolean isSenior() {
		return isSenior;
	}
	public void setSenior(boolean isSenior) {
		this.isSenior = isSenior;
	}
	public String getCandidateMobile() {
		return candidateMobile;
	}
	public void setCandidateMobile(String candidateMobile) {
		this.candidateMobile = candidateMobile;
	}
	public Integer getYearsOfExperience() {
		return yearsOfExperience;
	}
	public void setYearsOfExperience(Integer yearsOfExperience) {
		this.yearsOfExperience = yearsOfExperience;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	
	

}

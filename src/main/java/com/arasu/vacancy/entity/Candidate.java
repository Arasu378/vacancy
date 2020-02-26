package com.arasu.vacancy.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "v04_candidate")
public class Candidate {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "candidateId")
	private Integer candidateId;
	
	@Column(name = "firstName", length = 145, nullable =  false)
	private String firstName;
	
	@Column(name = "lastName", length = 145, nullable =  false)
	private String lastName;
	
	@Column(name = "email", length = 145, nullable = false)
	private String email;
	
	@Column(name = "mobile", length = 10, nullable = true)
	private String mobile;
	
	@Column(name = "YOE", length = 2, nullable = false)
	private Integer yearOfExperience;
	
	@Column(name = "createdAt")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdAt;
	
	@Column(name = "updatedAt")
	@Temporal(TemporalType.TIMESTAMP)
	private Date updatedAt;
	
	@Column(name = "candidatePreferredTime")
	@Temporal(TemporalType.TIMESTAMP)
	private Date candidatePreferredTime;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="userId")
	private User user;
	
	@Column(name = "senior")
	private Boolean isSenior;

	public Integer getCandidateId() {
		return candidateId;
	}

	public void setCandidateId(Integer candidateId) {
		this.candidateId = candidateId;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public Integer getYearOfExperience() {
		return yearOfExperience;
	}

	public void setYearOfExperience(Integer yearOfExperience) {
		this.yearOfExperience = yearOfExperience;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	
	public Date getCandidatePreferredTime() {
		return candidatePreferredTime;
	}

	public void setCandidatePreferredTime(Date candidatePreferredTime) {
		this.candidatePreferredTime = candidatePreferredTime;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Boolean getIsSenior() {
		return isSenior;
	}

	public void setIsSenior(Boolean isSenior) {
		this.isSenior = isSenior;
	}
	
	
	
	
	
	

}

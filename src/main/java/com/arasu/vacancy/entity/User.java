package com.arasu.vacancy.entity;


import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "v02_user")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "userId")
	private Integer userId;
	
	@Column(name = "firstName", length = 145, nullable = false)
	private String firstName;
	
	@Column(name = "lastName", length = 145, nullable =  false)
	private String lastName;
	
	@Column(name = "email", length = 145)
	private String email;
	
	@Column(name = "stgId", nullable = false)
	private Integer stgId;
	
	@Column(name = "password", nullable = false, columnDefinition = "LONGTEXT")
	@Lob
	private String password;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="roleId")
	private Role role;
	
	@Column(name = "createdAt")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdAt;
	
	@Column(name = "updatedAt")
	@Temporal(TemporalType.TIMESTAMP)
	private Date updatedAt;
	
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Candidate>candidates;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
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

	public Integer getStgId() {
		return stgId;
	}

	public void setStgId(Integer stgId) {
		this.stgId = stgId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Date getCreatedAt() {
		return createdAt;
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

	public List<Candidate> getCandidates() {
		return candidates;
	}

	public void setCandidates(List<Candidate> candidates) {
		this.candidates = candidates;
	}
	
	
	
	
	
	

}

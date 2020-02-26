package com.arasu.vacancy.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "v08_options")
public class Options {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer optionsId;
	
	@Column(name = "optionsName" , length = 145, nullable = false)
	private String optionsName;
	
	@Column(name = "createdAt")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdAt;
	
	@Column(name = "updatedAt")
	@Temporal(TemporalType.TIMESTAMP)
	private Date updatedAt;

	public Integer getOptionsId() {
		return optionsId;
	}

	public void setOptionsId(Integer optionsId) {
		this.optionsId = optionsId;
	}

	public String getOptionsName() {
		return optionsName;
	}

	public void setOptionsName(String optionsName) {
		this.optionsName = optionsName;
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

	
	
}

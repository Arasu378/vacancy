package com.arasu.vacancy.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "v14_sub_skill")
public class SubSkill {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "subSkillId")
	private Integer subSkillId;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "skillId")
	private Skill skill;
	
	@Column(name = "subSKillName", length = 75, nullable = false)
	private String subSKillName;
	
	@Column(name = "createdAt")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdAt;
	
	@Column(name = "updatedAt")
	@Temporal(TemporalType.TIMESTAMP)
	private Date updatedAt;

	public Integer getSubSkillId() {
		return subSkillId;
	}

	public void setSubSkillId(Integer subSkillId) {
		this.subSkillId = subSkillId;
	}

	public Skill getSkill() {
		return skill;
	}

	public void setSkill(Skill skill) {
		this.skill = skill;
	}

	public String getSubSKillName() {
		return subSKillName;
	}

	public void setSubSKillName(String subSKillName) {
		this.subSKillName = subSKillName;
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


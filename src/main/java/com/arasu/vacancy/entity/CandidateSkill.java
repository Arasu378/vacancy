package com.arasu.vacancy.entity;

import javax.persistence.*;

@Entity
@Table(name = "v05_candidate_skill")
public class CandidateSkill {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "candidateId")
	private Candidate candidate;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "subSKillId")
	private SubSkill subSkillId;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "skillId")
	private Skill skill;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Candidate getCandidate() {
		return candidate;
	}

	public void setCandidate(Candidate candidate) {
		this.candidate = candidate;
	}

	public Skill getSkill() {
		return skill;
	}

	public void setSkill(Skill skill) {
		this.skill = skill;
	}

	public SubSkill getSubSkillId() {
		return subSkillId;
	}

	public void setSubSkillId(SubSkill subSkillId) {
		this.subSkillId = subSkillId;
	}
	
	
	
	
	

}

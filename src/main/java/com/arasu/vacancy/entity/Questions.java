package com.arasu.vacancy.entity;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "v07_questions")
public class Questions {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "questionId")
	private Integer questionId;

	@Column(name = "question", nullable = false, columnDefinition = "LONGTEXT")
	@Lob
	private String question;
	
	@Column(name = "questionDescription", nullable = false, columnDefinition = "LONGTEXT")
	@Lob
	private String questionDescription;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "questionType")
	private QuestionType questionType;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "skillType")
	private Skill skill;
	
	@Column(name = "createdAt")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdAt;
	
	@Column(name = "updatedAt")
	@Temporal(TemporalType.TIMESTAMP)
	private Date updatedAt;

	public Integer getQuestionId() {
		return questionId;
	}

	public void setQuestionId(Integer questionId) {
		this.questionId = questionId;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getQuestionDescription() {
		return questionDescription;
	}

	public void setQuestionDescription(String questionDescription) {
		this.questionDescription = questionDescription;
	}

	public QuestionType getQuestionType() {
		return questionType;
	}

	public void setQuestionType(QuestionType questionType) {
		this.questionType = questionType;
	}

	public Skill getSkill() {
		return skill;
	}

	public void setSkill(Skill skill) {
		this.skill = skill;
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

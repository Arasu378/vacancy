package com.arasu.vacancy.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "v13_candidate_questions")
public class CandidateQuestions {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "questionPaperId")
	private Integer questionPaperId;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "questionId")
	private Questions questions;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "answerId")
	private QuestionAnswers answers;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "candidateId")
	private Candidate candidate;
	
	@Column(name = "createdAt")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdAt;
	
	@Column(name = "updatedAt")
	@Temporal(TemporalType.TIMESTAMP)
	private Date updatedAt;

	public Integer getQuestionPaperId() {
		return questionPaperId;
	}

	public void setQuestionPaperId(Integer questionPaperId) {
		this.questionPaperId = questionPaperId;
	}

	public Questions getQuestions() {
		return questions;
	}

	public void setQuestions(Questions questions) {
		this.questions = questions;
	}

	public QuestionAnswers getAnswers() {
		return answers;
	}

	public void setAnswers(QuestionAnswers answers) {
		this.answers = answers;
	}

	public Candidate getCandidate() {
		return candidate;
	}

	public void setCandidate(Candidate candidate) {
		this.candidate = candidate;
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

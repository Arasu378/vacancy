package com.arasu.vacancy.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "v11_candidate_answers")
public class CandidateAnswers {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn( name = "candidateId")
	private Candidate candidate;
	
	@Column(name = "candidateAnswer", columnDefinition = "LONGTEXT")
	@Lob
	private String candidateAnswer;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn( name = "questionPaperId")
	private CandidateQuestions questions;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn( name = "answerId")
	private QuestionAnswers questionAnswers;
	
	@Column(name = "createdAt")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdAt;
	
	@Column(name = "updatedAt")
	@Temporal(TemporalType.TIMESTAMP)
	private Date updatedAt;

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

	public String getCandidateAnswer() {
		return candidateAnswer;
	}

	public void setCandidateAnswer(String candidateAnswer) {
		this.candidateAnswer = candidateAnswer;
	}

	public CandidateQuestions getQuestions() {
		return questions;
	}

	public void setQuestions(CandidateQuestions questions) {
		this.questions = questions;
	}

	public QuestionAnswers getQuestionAnswers() {
		return questionAnswers;
	}

	public void setQuestionAnswers(QuestionAnswers questionAnswers) {
		this.questionAnswers = questionAnswers;
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

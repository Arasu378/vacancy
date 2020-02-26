package com.arasu.vacancy.entity;

import javax.persistence.*;

@Entity
@Table(name = "v09_question_options")
public class QuestionOptions {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "questionId")
	private Questions questions;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "optionsId")
	private Options options;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Questions getQuestions() {
		return questions;
	}

	public void setQuestions(Questions questions) {
		this.questions = questions;
	}

	public Options getOptions() {
		return options;
	}

	public void setOptions(Options options) {
		this.options = options;
	}
	
	

}

package com.arasu.vacancy.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "v06_question_type")
public class QuestionType {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "typeId")
	private Integer questionTypeId;
	
	@Column(name = "typeName", nullable =  false, length = 145)
	private String typeName;
	
	@Column(name = "createdAt")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdAt;
	
	@Column(name = "updatedAt")
	@Temporal(TemporalType.TIMESTAMP)
	private Date updatedAt;

	public Integer getQuestionTypeId() {
		return questionTypeId;
	}

	public void setQuestionTypeId(Integer questionTypeId) {
		this.questionTypeId = questionTypeId;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
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

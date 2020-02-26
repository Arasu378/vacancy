package com.arasu.vacancy.candidate.models;


import com.arasu.vacancy.entity.Candidate;

import java.util.List;

public class CandidateResponse {
	
	private boolean isSuccess;
	private String message;
	private Candidate candidate;
	private List<Candidate>candidateList;
	
	public CandidateResponse() {
		super();
	}
	public CandidateResponse(boolean isSuccess, String message, Candidate candidate, List<Candidate>candidateList) {
		super();
		this.isSuccess = isSuccess;
		this.message = message;
		this.candidate = candidate;
		this.candidateList = candidateList;
	}
	public boolean isSuccess() {
		return isSuccess;
	}
	public void setSuccess(boolean isSuccess) {
		this.isSuccess = isSuccess;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Candidate getCandidate() {
		return candidate;
	}
	public void setCandidate(Candidate candidate) {
		this.candidate = candidate;
	}
	public List<Candidate> getCandidateList() {
		return candidateList;
	}
	public void setCandidateList(List<Candidate> candidateList) {
		this.candidateList = candidateList;
	}
	
	
	

}

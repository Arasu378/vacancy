package com.arasu.vacancy.candidate.service;


import com.arasu.vacancy.candidate.models.CandidateInput;
import com.arasu.vacancy.candidate.models.CandidateResponse;
import com.arasu.vacancy.candidate.repository.CandidateRepository;
import com.arasu.vacancy.entity.Candidate;
import com.arasu.vacancy.entity.User;
import com.arasu.vacancy.user.repository.UserRepository;
import com.arasu.vacancy.util.Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CandidateService {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass().getSimpleName());
	
	@Autowired
	private CandidateRepository candidateRepository;
	@Autowired
	private UserRepository userRepository;
	
	public CandidateResponse insertCandidate(CandidateInput candidateInput) {
		Candidate candidate = candidateRepository.save(candidateObject(candidateInput));
		if (candidate != null) {
			return new CandidateResponse(true, "Successfull", candidate, null);
		}
		return new CandidateResponse(false, "candidate is not successfully saved", null, null);
	}
	public CandidateResponse getAllCandidates() {
		List<Candidate> candidateList = candidateRepository.findAll();
		if (candidateList != null) {
			return new CandidateResponse(true, "success",null, candidateList);
		}
		return new CandidateResponse(false, "failed to retrieve candidates list", null, null);
	}
	
	private Candidate candidateObject(CandidateInput candidateInput) {
		Candidate candidate = new Candidate();
		candidate.setCandidatePreferredTime(Utils.dateFormatter(candidateInput.getCandidatePreferredTime()));
		candidate.setCreatedAt(Utils.currentDate());
		candidate.setEmail(candidateInput.getCandidateEmail());
		candidate.setFirstName(candidateInput.getFirstName());
		candidate.setLastName(candidateInput.getLastName());
		candidate.setIsSenior(candidateInput.isSenior());
		candidate.setMobile(candidateInput.getCandidateMobile());
		candidate.setUpdatedAt(Utils.currentDate());
		candidate.setYearOfExperience(candidateInput.getYearsOfExperience());
		candidate.setUser(getUser(candidateInput.getUserId()));
		return candidate;
	}
	
	private User getUser(Integer id) {
		User user = userRepository.findById(id);
		if (user != null) {
			logger.info(user.getEmail());
			return user;
		}
		logger.info("User Info :: null");
		return null;
	}

}

package com.arasu.vacancy.candidate_answers.service;


import com.arasu.vacancy.candidate_answers.repository.CandidateAnswerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CandidateAnswerService {
    @Autowired
    private CandidateAnswerRepository candidateAnswerRepository;
}

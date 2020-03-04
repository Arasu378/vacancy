package com.arasu.vacancy.candidate_answers.repository;

import com.arasu.vacancy.entity.CandidateAnswers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CandidateAnswerRepository extends JpaRepository<CandidateAnswers, Integer> {
}

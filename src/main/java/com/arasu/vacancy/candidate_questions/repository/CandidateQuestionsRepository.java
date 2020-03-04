package com.arasu.vacancy.candidate_questions.repository;

import com.arasu.vacancy.entity.CandidateQuestions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CandidateQuestionsRepository  extends JpaRepository<CandidateQuestions, Integer> {
    @Query("select s from CandidateQuestions s where s.candidate.candidateId=:id")
    List<CandidateQuestions> getCandidateQuestionsByCandidateId(@Param("id") Integer id);
}

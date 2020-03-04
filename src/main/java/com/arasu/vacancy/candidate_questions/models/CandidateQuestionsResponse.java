package com.arasu.vacancy.candidate_questions.models;

import com.arasu.vacancy.entity.CandidateQuestions;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
@AllArgsConstructor
@Data
public class CandidateQuestionsResponse {
    private Boolean isSucess;
    private String message;
    private CandidateQuestions candidateQuestions;
    private List<CandidateQuestions> candidateQuestionsList;
}

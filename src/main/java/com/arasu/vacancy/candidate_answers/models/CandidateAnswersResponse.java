package com.arasu.vacancy.candidate_answers.models;

import com.arasu.vacancy.entity.CandidateAnswers;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class CandidateAnswersResponse {
    private Boolean isSuccess;
    private String message;
    private CandidateAnswers candidateAnswers;
    private List<CandidateAnswers> candidateAnswersList;
}

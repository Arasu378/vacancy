package com.arasu.vacancy.candidate_answers.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CandidateAnswersInput {
    private String candidateAnswer;
    private Integer candidateId;
    private Integer answerId;
    private Integer questionPaperId;
}

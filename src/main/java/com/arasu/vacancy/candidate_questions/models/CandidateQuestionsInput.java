package com.arasu.vacancy.candidate_questions.models;

import lombok.Data;

@Data
public class CandidateQuestionsInput {
    private Integer candidateId;
    private Integer questionId;
    private Integer answerId;
}

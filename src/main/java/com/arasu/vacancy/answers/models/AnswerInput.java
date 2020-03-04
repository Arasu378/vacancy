package com.arasu.vacancy.answers.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class AnswerInput {
    private String answer;
    private Integer questionId;

}

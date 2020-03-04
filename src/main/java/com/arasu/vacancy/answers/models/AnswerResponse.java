package com.arasu.vacancy.answers.models;

import com.arasu.vacancy.entity.QuestionAnswers;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class AnswerResponse {

    private Boolean isSuccess;
    private String message;
    private QuestionAnswers answers;
    private List<QuestionAnswers> answersList;

}

package com.arasu.vacancy.questions.models;

import com.arasu.vacancy.entity.Questions;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class QuestionResponse {
    private Boolean isSuccess;
    private String message;
    private Questions questions;
    private List<Questions> questionsList;


}

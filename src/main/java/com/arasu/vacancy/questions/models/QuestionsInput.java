package com.arasu.vacancy.questions.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class QuestionsInput {

    private String question;
    private String questionDescription;
    private Integer questionTypeId;
    private Integer subSkillId;

}

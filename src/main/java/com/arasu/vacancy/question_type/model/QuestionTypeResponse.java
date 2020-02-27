package com.arasu.vacancy.question_type.model;

import com.arasu.vacancy.util.CommonResponse;

import java.util.List;

public class QuestionTypeResponse extends CommonResponse {
    private String test;

    public QuestionTypeResponse(Boolean isSuccess, String message, Object object, List list) {
        super(isSuccess, message, object, list);
    }

    public String getTest() {
        return test;
    }

    public void setTest(String test) {
        this.test = test;
    }
}

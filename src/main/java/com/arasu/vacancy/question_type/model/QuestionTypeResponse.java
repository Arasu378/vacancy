package com.arasu.vacancy.question_type.model;

import com.arasu.vacancy.entity.QuestionType;
import com.arasu.vacancy.util.CommonResponse;

import java.util.List;

public class QuestionTypeResponse  {
    private Boolean isSuccess;
    private String message;
    private QuestionType questionType;
    private List<QuestionType>  questionTypeList;


    public QuestionTypeResponse(Boolean isSuccess, String message, QuestionType questionType, List<QuestionType> questionTypeList) {
        this.isSuccess = isSuccess;
        this.message = message;
        this.questionType = questionType;
        this.questionTypeList = questionTypeList;
    }

    public Boolean getSuccess() {
        return isSuccess;
    }

    public void setSuccess(Boolean success) {
        isSuccess = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public QuestionType getQuestionType() {
        return questionType;
    }

    public void setQuestionType(QuestionType questionType) {
        this.questionType = questionType;
    }

    public List<QuestionType> getQuestionTypeList() {
        return questionTypeList;
    }

    public void setQuestionTypeList(List<QuestionType> questionTypeList) {
        this.questionTypeList = questionTypeList;
    }
}

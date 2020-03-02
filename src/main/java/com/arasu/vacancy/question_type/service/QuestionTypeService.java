package com.arasu.vacancy.question_type.service;

import com.arasu.vacancy.entity.QuestionType;
import com.arasu.vacancy.question_type.model.QuestionTypeInput;
import com.arasu.vacancy.question_type.model.QuestionTypeResponse;
import com.arasu.vacancy.question_type.repository.QuestionTypeRepository;
import com.arasu.vacancy.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class QuestionTypeService {

    @Autowired
    private QuestionTypeRepository questionTypeRepository;

    public QuestionTypeResponse saveQuestionType(QuestionTypeInput questionTypeInput) {
        QuestionType questionType = questionTypeRepository.save(convertData(questionTypeInput));
        if (questionType != null) {
            return new QuestionTypeResponse(true, "Success", questionType, null);
        }
        return new QuestionTypeResponse(false, "Failed", null, null);
    }
    private QuestionType convertData(QuestionTypeInput  questionTypeInput) {
        QuestionType questionType = new QuestionType();
        questionType.setTypeName(questionTypeInput.getQuestionType());
        questionType.setCreatedAt(Utils.currentDate());
        questionType.setUpdatedAt(Utils.currentDate());
        return questionType;
    }
}

package com.arasu.vacancy.question_type.service;

import com.arasu.vacancy.question_type.model.QuestionTypeResponse;
import com.arasu.vacancy.question_type.repository.QuestionTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuestionTypeService {

    @Autowired
    private QuestionTypeRepository questionTypeRepository;

    public QuestionTypeResponse test() {
        return null;
    }
}

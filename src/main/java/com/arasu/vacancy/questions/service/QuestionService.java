package com.arasu.vacancy.questions.service;

import com.arasu.vacancy.questions.repository.QuestionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuestionService {
    @Autowired
    private QuestionsRepository questionsRepository;
}

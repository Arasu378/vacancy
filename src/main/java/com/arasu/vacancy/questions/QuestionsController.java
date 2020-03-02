package com.arasu.vacancy.questions;

import com.arasu.vacancy.questions.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QuestionsController {
    @Autowired
    private QuestionService questionService;
}

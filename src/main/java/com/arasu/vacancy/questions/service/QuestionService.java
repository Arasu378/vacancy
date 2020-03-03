package com.arasu.vacancy.questions.service;

import com.arasu.vacancy.entity.QuestionType;
import com.arasu.vacancy.entity.Questions;
import com.arasu.vacancy.entity.SubSkill;
import com.arasu.vacancy.question_type.repository.QuestionTypeRepository;
import com.arasu.vacancy.questions.models.QuestionResponse;
import com.arasu.vacancy.questions.models.QuestionsInput;
import com.arasu.vacancy.questions.repository.QuestionsRepository;
import com.arasu.vacancy.skills.repository.SubSkillsRepository;
import com.arasu.vacancy.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {
    @Autowired
    private QuestionsRepository questionsRepository;

    @Autowired
    private QuestionTypeRepository questionTypeRepository;

    @Autowired
    private SubSkillsRepository subSkillsRepository;

    public QuestionResponse saveQuestionType(QuestionsInput questionsInput) {
        Questions questions = questionsRepository.save(getData(questionsInput));
        if (questions != null) {
            return new QuestionResponse(true, "Success", questions, null);
        }
        return new QuestionResponse(true, "Success", null, null);
    }

    private Questions getData(QuestionsInput questionsInput) {
        Questions questions = new Questions();
        questions.setCreatedAt(Utils.currentDate());
        questions.setUpdatedAt(Utils.currentDate());
        questions.setQuestion(questionsInput.getQuestion());
        questions.setQuestionDescription(questionsInput.getQuestionDescription());
        QuestionType questionType = questionTypeRepository.findById(questionsInput.getQuestionTypeId()).orElse(new QuestionType());
        questions.setQuestionType(questionType);
        SubSkill subSkill = subSkillsRepository.findById(questionsInput.getSubSkillId()).orElse(new SubSkill());
        questions.setSkill(subSkill);
        return questions;

    }

    public QuestionResponse getQuestionById(Integer id) {
        Questions questions = questionsRepository.findById(id).orElse(new Questions());
        return new QuestionResponse(true, "Success", questions, null);
    }
    public QuestionResponse getQuestionByTypeId(Integer id) {
        List<Questions> questions = questionsRepository.findByTypeId(id);
        if (questions != null && questions.size() != 0) {
            return new QuestionResponse(true, "Success", null, questions);
        }
        return new QuestionResponse(false, "Failed", null, null);
    }
    public QuestionResponse getQuestionBySubSkillId(Integer id) {
        List<Questions> questions = questionsRepository.findBySubSkillId(id);
        if (questions != null && questions.size() != 0) {
            return new QuestionResponse(true, "Success", null, questions);
        }
        return new QuestionResponse(false, "Failed", null, null);
    }
    public QuestionResponse getAllQuestions() {
        List<Questions> questions = questionsRepository.findAll();
        if (questions != null && questions.size() != 0) {
            return new QuestionResponse(true, "Success", null, questions);
        }
        return new QuestionResponse(false, "Failed", null, questions);
    }
}

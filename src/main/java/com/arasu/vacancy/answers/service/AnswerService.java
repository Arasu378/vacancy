package com.arasu.vacancy.answers.service;

import com.arasu.vacancy.answers.models.AnswerInput;
import com.arasu.vacancy.answers.models.AnswerResponse;
import com.arasu.vacancy.answers.repository.AnswerRepository;
import com.arasu.vacancy.entity.QuestionAnswers;
import com.arasu.vacancy.entity.Questions;
import com.arasu.vacancy.questions.repository.QuestionsRepository;
import com.arasu.vacancy.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnswerService {
    @Autowired
    private AnswerRepository answerRepository;

    @Autowired
    private QuestionsRepository questionsRepository;

    public AnswerResponse getAllAnswers() {
        List<QuestionAnswers> answers = answerRepository.findAll();
        if (answers != null && answers.size() != 0) {
            return new AnswerResponse(true, "Success", null, answers);
        }
        return new AnswerResponse(false, "List is Empty", null, null);
    }
    public AnswerResponse saveAnswer(AnswerInput answerInput) {
        QuestionAnswers answers = answerRepository.save(dataConvert(answerInput));
        if (answers != null) {
            return new AnswerResponse(true, "Success", answers, null);
        }
        return new AnswerResponse(false, "Failed to insert", answers, null);
    }
    private QuestionAnswers dataConvert(AnswerInput answerInput) {
        QuestionAnswers answers = new QuestionAnswers();
        answers.setAnswer(answerInput.getAnswer());
        answers.setCreatedAt(Utils.currentDate());
        answers.setUpdatedAt(Utils.currentDate());
        Questions questions = questionsRepository.findById(answerInput.getQuestionId()).orElseThrow(RuntimeException::new);
        answers.setQuestions(questions);
        return answers;
    }

    public AnswerResponse findAnswersById(Integer id) {
        QuestionAnswers questionAnswers = answerRepository.findById(id).orElse(new QuestionAnswers());
        if (questionAnswers.getId() != 0) {
            return new AnswerResponse(true, "Success", questionAnswers, null);
        }
        return new AnswerResponse(false, "no Object found ", null, null);
    }

    public AnswerResponse findAnswersByQuestionId(Integer id) {
        QuestionAnswers questionAnswers = answerRepository.findAnswersByQuestionId(id);
        if (questionAnswers != null ) {
            return new AnswerResponse(true, "Success", questionAnswers, null);
        }
        return new AnswerResponse(false, "no Object found ", null, null);
    }
}

package com.arasu.vacancy.candidate_questions.service;

import com.arasu.vacancy.answers.repository.AnswerRepository;
import com.arasu.vacancy.candidate.repository.CandidateRepository;
import com.arasu.vacancy.candidate_questions.models.CandidateQuestionsInput;
import com.arasu.vacancy.candidate_questions.models.CandidateQuestionsResponse;
import com.arasu.vacancy.candidate_questions.repository.CandidateQuestionsRepository;
import com.arasu.vacancy.entity.Candidate;
import com.arasu.vacancy.entity.CandidateQuestions;
import com.arasu.vacancy.entity.QuestionAnswers;
import com.arasu.vacancy.entity.Questions;
import com.arasu.vacancy.questions.repository.QuestionsRepository;
import com.arasu.vacancy.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CandidateQuestionsService {

    @Autowired
    private CandidateQuestionsRepository candidateQuestionsRepository;

    @Autowired
    private CandidateRepository candidateRepository;

    @Autowired
    private AnswerRepository answerRepository;

    @Autowired
    private QuestionsRepository questionsRepository;

    public CandidateQuestionsResponse insertCandidateQuestions(CandidateQuestionsInput candidateQuestionsInput) {
        CandidateQuestions candidateQuestions = candidateQuestionsRepository.save(convertData(candidateQuestionsInput));
        if (candidateQuestions != null) {
            return new CandidateQuestionsResponse(true, "Success", candidateQuestions, null);
        }
        return new CandidateQuestionsResponse(false, "Candidate Questions is not saved", candidateQuestions, null);
    }
    public CandidateQuestionsResponse getById(Integer id) {
        CandidateQuestions candidateQuestions = candidateQuestionsRepository.findById(id).orElse(new CandidateQuestions());
        if (candidateQuestions.getQuestionPaperId() != 0) {
            return new CandidateQuestionsResponse(true, "Success", candidateQuestions, null);
        }
        return new CandidateQuestionsResponse(false, "No Candidate question found", candidateQuestions, null);
    }
    public CandidateQuestionsResponse getAllCandidateQuestions() {
        List<CandidateQuestions> candidateQuestionsList = candidateQuestionsRepository.findAll();
        if (candidateQuestionsList != null && candidateQuestionsList.size() != 0 ){
            return new CandidateQuestionsResponse(true, "Success", null, candidateQuestionsList);
        }
        return new CandidateQuestionsResponse(false, "No Questions Found", null, candidateQuestionsList);
    }
    public CandidateQuestionsResponse getCandidateQuestionsByCandidateId(Integer id) {
        List<CandidateQuestions> candidateQuestionsList = candidateQuestionsRepository.getCandidateQuestionsByCandidateId(id);
        if (candidateQuestionsList != null && candidateQuestionsList.size() != 0 ){
            return new CandidateQuestionsResponse(true, "Success", null, candidateQuestionsList);
        }
        return new CandidateQuestionsResponse(false, "No Questions Found", null, candidateQuestionsList);
    }
    private CandidateQuestions convertData(CandidateQuestionsInput candidateQuestionsInput) {
        CandidateQuestions candidateQuestions = new CandidateQuestions();
        QuestionAnswers questionAnswers = answerRepository.findById(candidateQuestionsInput.getAnswerId()).orElseThrow(RuntimeException::new);
        candidateQuestions.setAnswers(questionAnswers);
        Candidate candidate = candidateRepository.findById(candidateQuestionsInput.getCandidateId()).orElseThrow(RuntimeException::new);
        candidateQuestions.setCandidate(candidate);
        candidateQuestions.setCreatedAt(Utils.currentDate());
        candidateQuestions.setUpdatedAt(Utils.currentDate());
        Questions questions = questionsRepository.findById(candidateQuestionsInput.getQuestionId()).orElseThrow(RuntimeException::new);
        candidateQuestions.setQuestions(questions);
        return candidateQuestions;
    }
}

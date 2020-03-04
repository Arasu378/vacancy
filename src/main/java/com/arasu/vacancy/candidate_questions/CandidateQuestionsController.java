package com.arasu.vacancy.candidate_questions;

import com.arasu.vacancy.candidate_questions.models.CandidateQuestionsInput;
import com.arasu.vacancy.candidate_questions.models.CandidateQuestionsResponse;
import com.arasu.vacancy.candidate_questions.service.CandidateQuestionsService;
import com.arasu.vacancy.question_type.model.QuestionTypeInput;
import com.arasu.vacancy.question_type.model.QuestionTypeResponse;
import com.arasu.vacancy.util.Constants;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Api(value = "CandidateQuestions", description = "add, update question (candidate) list")
@RequestMapping(value = Constants.CANDIDATE_QUESTIONS)
@ApiResponses(value = {
        @ApiResponse(code = 200, message = "Successfull"),
        @ApiResponse(code = 401, message = "You are not authorized "),
        @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
        @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
})
@RestController
public class CandidateQuestionsController {
    @Autowired
    private CandidateQuestionsService candidateQuestionsService;

    @ApiOperation(value = "Question to save", response = CandidateQuestionsResponse.class)
    @RequestMapping(path = Constants.CANDIDATE_QUESTIONS_SAVE, method = RequestMethod.POST)
    public CandidateQuestionsResponse addQuestion(@ApiParam(value = "question  details to save", required = true)
                                                @Valid @RequestBody CandidateQuestionsInput candidateQuestionsInput) {
        return candidateQuestionsService.insertCandidateQuestions(candidateQuestionsInput);
    }

    @ApiOperation(value = "Get all candidate questions", response = CandidateQuestionsResponse.class)
    @RequestMapping(path = Constants.CANDIDATE_QUESTIONS_ALL, method = RequestMethod.GET)
    public CandidateQuestionsResponse getAllCandidateQuestions() {
        return candidateQuestionsService.getAllCandidateQuestions();
    }
    @ApiOperation(value = "Get all candidate questions", response = CandidateQuestionsResponse.class)
    @RequestMapping(path = Constants.CANDIDATE_QUESTIONS_BY_CANDIDATE_ID, method = RequestMethod.GET)
    public CandidateQuestionsResponse getAllCandidateQuestionsByCandidateId(@ApiParam(value = "Candidate id", required = true)
                                                               @PathVariable(value = "candidateId") Integer candidateId) {
        return candidateQuestionsService.getCandidateQuestionsByCandidateId(candidateId);
    }
    @ApiOperation(value = "Get all candidate questions by id", response = CandidateQuestionsResponse.class)
    @RequestMapping(path = Constants.CANDIDATE_QUESTIONS_BY_ID, method = RequestMethod.GET)
    public CandidateQuestionsResponse getAllCandidateQuestionsById(@ApiParam(value = "id", required = true)
                                                               @PathVariable(value = "id") Integer id) {
        return candidateQuestionsService.getById(id);
    }
}

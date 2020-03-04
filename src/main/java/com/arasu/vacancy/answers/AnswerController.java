package com.arasu.vacancy.answers;


import com.arasu.vacancy.answers.models.AnswerInput;
import com.arasu.vacancy.answers.models.AnswerResponse;
import com.arasu.vacancy.answers.service.AnswerService;
import com.arasu.vacancy.questions.models.QuestionResponse;
import com.arasu.vacancy.questions.models.QuestionsInput;
import com.arasu.vacancy.util.Constants;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Api(value = "Answers", description = "add, update answer  list")
@RequestMapping(value = Constants.ANSWERS)
@ApiResponses(value = {
        @ApiResponse(code = 200, message = "Successful"),
        @ApiResponse(code = 401, message = "You are not authorized "),
        @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
        @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
})
@RestController
public class AnswerController {

    @Autowired
    private AnswerService answerService;

    @ApiOperation(value = "Answers to save", response = AnswerResponse.class)
    @RequestMapping(path = Constants.ANSWER_SAVE, method = RequestMethod.POST)
    public AnswerResponse saveAnswer(@ApiParam(value = "answer  details to save", required = true)
                                        @Valid @RequestBody AnswerInput answerInput) {
        return answerService.saveAnswer(answerInput);
    }

    @ApiOperation(value = "get Answer By Id", response = AnswerResponse.class)
    @RequestMapping(path = Constants.ANSWER_GET_BY_ID, method = RequestMethod.GET)
    public AnswerResponse getByAnswerId(@ApiParam(value = "Answer Id", required = true)
                                            @PathVariable(value = "answerId") Integer id) {
        return answerService.findAnswersById(id);
    }

    @ApiOperation(value = "get Answer By QuestionId", response = AnswerResponse.class)
    @RequestMapping(path = Constants.ANSWER_GET_BY_QUESTION_ID, method = RequestMethod.GET)
    public AnswerResponse getByAnswerQuestionId(@ApiParam(value = "Question Id", required = true)
                                        @PathVariable(value = "questionId") Integer id) {
        return answerService.findAnswersByQuestionId(id);
    }

    @ApiOperation(value = "get All Answers", response = AnswerResponse.class)
    @RequestMapping(path = Constants.ANSWER_GET_ALL, method = RequestMethod.GET)
    public AnswerResponse getAllAnswers() {
        return answerService.getAllAnswers();
    }

}

package com.arasu.vacancy.questions;

import com.arasu.vacancy.question_type.model.QuestionTypeInput;
import com.arasu.vacancy.question_type.model.QuestionTypeResponse;
import com.arasu.vacancy.questions.models.QuestionResponse;
import com.arasu.vacancy.questions.models.QuestionsInput;
import com.arasu.vacancy.questions.service.QuestionService;
import com.arasu.vacancy.util.Constants;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@Api(value = "Question", description = "add, update question  list")
@RequestMapping(value = Constants.QUESTION)
@ApiResponses(value = {
        @ApiResponse(code = 200, message = "Successful"),
        @ApiResponse(code = 401, message = "You are not authorized "),
        @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
        @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
})
@RestController
public class QuestionsController {
    @Autowired
    private QuestionService questionService;

    @ApiOperation(value = "Question to save", response = QuestionResponse.class)
    @RequestMapping(path = Constants.QUESTION_SAVE, method = RequestMethod.POST)
    public QuestionResponse addQuestion(@ApiParam(value = "question  details to save", required = true)
                                                @Valid @RequestBody QuestionsInput questionInput) {
        return questionService.saveQuestionType(questionInput);


    }

    @ApiOperation(value = "get Question By Id", response = QuestionResponse.class)
    @RequestMapping(path = Constants.QUESTIONS_GET_BY_ID, method = RequestMethod.GET)
    public QuestionResponse getByQuestionId(@ApiParam(value = "question Id", required = true)
                                            @PathVariable(value = "questionId") Integer id) {
        return questionService.getQuestionById(id);
    }

    @ApiOperation(value = "get Question By Type Id", response = QuestionResponse.class)
    @RequestMapping(path = Constants.QUESTIONS_GET_BY_TYPE_ID, method = RequestMethod.GET)
    public QuestionResponse getByTypeId(@ApiParam(value = "question type Id", required = true)
                                            @PathVariable(value = "typeId") Integer id) {
        return questionService.getQuestionByTypeId(id);
    }
    @ApiOperation(value = "get Question By sub skill Id", response = QuestionResponse.class)
    @RequestMapping(path = Constants.QUESTIONS_GET_BY_SUB_SKILL_ID, method = RequestMethod.GET)
    public QuestionResponse getBySubSkillId(@ApiParam(value = "subSkill Id", required = true)
                                        @PathVariable(value = "subSkillId") Integer id) {
        return questionService.getQuestionByTypeId(id);
    }
    @ApiOperation(value = "get all questions", response = QuestionResponse.class)
    @RequestMapping(path = Constants.QUESTIONS_GET_ALL, method = RequestMethod.GET)
    public QuestionResponse getAllQuestions() {
        return questionService.getAllQuestions();
    }
}

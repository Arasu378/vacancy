package com.arasu.vacancy.question_type;

import com.arasu.vacancy.question_type.model.QuestionTypeInput;
import com.arasu.vacancy.question_type.model.QuestionTypeResponse;
import com.arasu.vacancy.question_type.service.QuestionTypeService;
import com.arasu.vacancy.skills.models.SubSkillsInput;
import com.arasu.vacancy.skills.models.SubSkillsResponse;
import com.arasu.vacancy.util.Constants;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Api(value = "QuestionTypes", description = "add, update question types list")
@RequestMapping(value = Constants.QUESTION_TYPE)
@ApiResponses(value = {
        @ApiResponse(code = 200, message = "Successfull"),
        @ApiResponse(code = 401, message = "You are not authorized "),
        @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
        @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
})
@RestController
public class QuestionTypeController {

    @Autowired
    private QuestionTypeService questionTypeService;


    @ApiOperation(value = "test", response = QuestionTypeResponse.class)
    @RequestMapping(path = Constants.SAVE_SUB_SKILL, method = RequestMethod.POST)
    public QuestionTypeResponse addQuestionType(@ApiParam(value = "sub skills details to save", required = true)
                                          @Valid @RequestBody QuestionTypeInput questionTypeInput) {
        return questionTypeService.test();
    }

}

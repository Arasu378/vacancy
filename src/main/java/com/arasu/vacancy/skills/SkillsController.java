package com.arasu.vacancy.skills;

import com.arasu.vacancy.skills.models.SkillsInput;
import com.arasu.vacancy.skills.models.SkillsResponse;
import com.arasu.vacancy.skills.models.SubSkillsInput;
import com.arasu.vacancy.skills.models.SubSkillsResponse;
import com.arasu.vacancy.skills.service.SkillsService;
import com.arasu.vacancy.skills.service.SubSkillService;
import com.arasu.vacancy.util.Constants;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Api(value = "Skills", description = "add, update skills list")
@RequestMapping(value = Constants.SKILLS)
@ApiResponses(value = {
        @ApiResponse(code = 200, message = "Successfull"),
        @ApiResponse(code = 401, message = "You are not authorized "),
        @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
        @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
})
@RestController
public class SkillsController {
    @Autowired
    private SubSkillService subSkillService;

    @Autowired
    private SkillsService skillsService;

    @ApiOperation(value = "save sub skills", response = SubSkillsResponse.class)
    @RequestMapping(path = Constants.SAVE_SUB_SKILL, method = RequestMethod.POST)
    public SubSkillsResponse addSubSkills(@ApiParam(value = "sub skills details to save", required = true)
                                          @Valid @RequestBody SubSkillsInput subSkillsInput) {
        return subSkillService.saveSubSkill(subSkillsInput);
    }

    @ApiOperation(value = "save sub skills", response = SubSkillsResponse.class)
    @RequestMapping(path = Constants.SAVE_SUB_SKILL, method = RequestMethod.PUT)
    public SubSkillsResponse updateSubSkills(@ApiParam(value = "sub skills details to save", required = true)
                                          @Valid @RequestBody SubSkillsInput subSkillsInput) {
        return subSkillService.saveSubSkill(subSkillsInput);
    }

    @ApiOperation(value = "save sub skills", response = SkillsResponse.class)
    @RequestMapping(path = Constants.SAVE_SKILL, method = RequestMethod.POST)
    public SkillsResponse addSkills(@ApiParam(value = "skills details to save", required = true)
                                          @Valid @RequestBody SkillsInput skillsInput) {
        return skillsService.saveSkills(skillsInput);
    }

    @ApiOperation(value = "save sub skills", response = SkillsResponse.class)
    @RequestMapping(path = Constants.SAVE_SKILL, method = RequestMethod.PUT)
    public SkillsResponse updateSkills(@ApiParam(value = "skills details to save", required = true)
                                    @Valid @RequestBody SkillsInput skillsInput) {
        return skillsService.saveSkills(skillsInput);
    }


    @ApiOperation(value = "get all sub skills", response = SubSkillsResponse.class)
    @RequestMapping(path = Constants.GET_ALL_SUB_SKILL, method = RequestMethod.GET)
    public SubSkillsResponse getAllSubSkills() {
        return subSkillService.getAllSubSkills();
    }

    @ApiOperation(value = "get all skills", response = SkillsResponse.class)
    @RequestMapping(path = Constants.GET_ALL_SKILL, method = RequestMethod.GET)
    public SkillsResponse getAllSkills() {
        return skillsService.getAllSkills();
    }



    @ApiOperation(value = "get sub skills", response = SubSkillsResponse.class)
    @RequestMapping(path = Constants.GET_SUB_SKILL_BY_ID, method = RequestMethod.GET)
    public SubSkillsResponse getSubSkillsById(@PathVariable("subSkillId") Integer subSkillId) {
        return subSkillService.getSubSkillById(subSkillId);
    }

    @ApiOperation(value = "get skills", response = SkillsResponse.class)
    @RequestMapping(path = Constants.GET_SKILL_BY_ID, method = RequestMethod.GET)
    public SkillsResponse getSkillsById(@PathVariable("skillId") Integer skillId) {
        return skillsService.getSkillById(skillId);
    }



    @ApiOperation(value = "get sub skills by Skill Id", response = SubSkillsResponse.class)
    @RequestMapping(path = Constants.GET_SUB_SKILL_BY_SKILL_ID, method = RequestMethod.GET)
    public SubSkillsResponse getSubSkillsBySkillId(@PathVariable("skillId") Integer skillId) {
        return subSkillService.getSubSkillBySkillId(skillId);
    }

}

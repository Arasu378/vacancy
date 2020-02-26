package com.arasu.vacancy.candidate;


import com.arasu.vacancy.candidate.models.CandidateInput;
import com.arasu.vacancy.candidate.models.CandidateResponse;
import com.arasu.vacancy.candidate.service.CandidateService;
import com.arasu.vacancy.util.Constants;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@Api(value = "Candidate persons", description = "add, update candidate list")
@RequestMapping(value = Constants.CANDIDATE)
@ApiResponses(value = {
        @ApiResponse(code = 200, message = "Successfull"),
        @ApiResponse(code = 401, message = "You are not authorized "),
        @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
        @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
public class CandidateController {
	
	@Autowired
	private CandidateService candidateService;
	
	@ApiOperation(value = "Registering New Candidate", response = CandidateResponse.class)
	@RequestMapping(path = Constants.CANDIDATE_REGISTER, method = RequestMethod.POST)
	public CandidateResponse addCandidate(@ApiParam(value = "candidate details to save", required = true)
	@Valid @RequestBody CandidateInput candidateInput) {
		return candidateService.insertCandidate(candidateInput);
	}
	
	@ApiOperation(value = "Get All Candidate", response = CandidateResponse.class)
	@RequestMapping(path = Constants.GET_ALL_CANDIDATES, method = RequestMethod.GET)
	public CandidateResponse getAllCandidates() {
		return candidateService.getAllCandidates();
	}
	

}

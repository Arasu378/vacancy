package com.arasu.vacancy.user;


import com.arasu.vacancy.entity.User;
import com.arasu.vacancy.user.model.RegisterResponse;
import com.arasu.vacancy.user.model.UserInput;
import com.arasu.vacancy.user.service.UserService;
import com.arasu.vacancy.util.Constants;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@Api(value="User Controls", description = "Users with Controls")
@RequestMapping(value = Constants.USER)
@ApiResponses(value = {
        @ApiResponse(code = 200, message = "Successfull"),
        @ApiResponse(code = 401, message = "You are not authorized"),
        @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
        @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
public class UserController {
	@Autowired
	private UserService userService;
	
	
	
	@ApiOperation(value = "Registering New User", response = RegisterResponse.class)
	@RequestMapping(path = Constants.REGISTER, method = RequestMethod.POST)
	public RegisterResponse register(@ApiParam(value = "User details to store", required = true)
									@Valid @RequestBody UserInput user) {
		return userService.registerUser(user);
	}
	
	
	@ApiOperation(value = "Users Login", response = RegisterResponse.class)
	@RequestMapping(path = Constants.LOGIN, method = RequestMethod.PUT)
	public RegisterResponse login(@ApiParam(value = "User details to store", required = true)
									@Valid @RequestBody UserInput user) {
		return userService.login(user);
	}
	@ApiOperation(value = "Users authentication", response = RegisterResponse.class)
	@RequestMapping(path = Constants.AUTHENTICATION, method = RequestMethod.PUT)
	public RegisterResponse userAuthentication(@ApiParam(value = "User details to authentication", required = true)
								  @Valid @RequestBody UserInput user) {
		return userService.authentication(user);
	}
	
	@ApiOperation(value = "Get All Candidate By User ID", response = RegisterResponse.class)
	@RequestMapping(path = Constants.GET_ALL_CANDIDATES_BY_USER_ID, method = RequestMethod.GET)
	public RegisterResponse getAllCandidatesByUserId(@PathVariable(name = "userId") Integer userId) {
		return userService.getAllCandidatesByUserId(userId);
	}

	@ApiOperation(value = "Get All Users", response = RegisterResponse.class)
	@RequestMapping(path = Constants.GET_ALL_CANDIDATES_T, method = RequestMethod.GET)
	public List<User> getAllUsers() {
		return userService.getAll();
	}
}

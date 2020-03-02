package com.arasu.vacancy.user.service;


import com.arasu.vacancy.authentication.JWTTokenUtil;
import com.arasu.vacancy.entity.Role;
import com.arasu.vacancy.entity.User;
import com.arasu.vacancy.mail.MailController;
import com.arasu.vacancy.user.model.RegisterResponse;
import com.arasu.vacancy.user.model.UserInput;
import com.arasu.vacancy.user.model.UserPrincipal;
import com.arasu.vacancy.user.repository.UserRepository;
import com.arasu.vacancy.util.Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;


@Service
public class UserService implements UserDetailsService {
	private Logger logger = LoggerFactory.getLogger(this.getClass().getSimpleName());
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private MailController mailController;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private JWTTokenUtil jwtTokenUtil;

	@Autowired
	private AuthenticationManager authenticationManager;
	
	private String title = "Vacany Application Password";
	private String message = "Welcome to Vacancy application your password is : ";
	private String hashPass = getHashedPassWord();
	
	public RegisterResponse registerUser(UserInput userInput) {
		
//		try {
//			mailController.sendMail(userInput.getEmail(), title, hashPass);
//		} catch (MessagingException e) {
//			e.printStackTrace();
//		}
		logger.info(hashPass);
		User user = userRepository.findByEmail(userInput.getEmail());
		if (user == null) {
			User output = userRepository.save(getUser(userInput));
			if (output != null) {
				return new RegisterResponse(true, "User is registered, Check mail for Password", null, null);
			}
			return new RegisterResponse(false, "User is not registered", null, null);
		} else {
			return new RegisterResponse(false, "User is already registered", null, null);
		}

	}
	public RegisterResponse login(UserInput userInput) {
		User user = userRepository.findByEmail(userInput.getEmail());
		String jwt = jwtTokenUtil.generateToken(loadUserByUsername(userInput.getEmail()));
		boolean match = Utils.checkPass(userInput.getPassword(), user.getPassword());
		if (match) {
			return new RegisterResponse(true, "Login Successfull", user, jwt);
		}
		return new RegisterResponse(false, "Check you email and password", null, null);
	}

	public RegisterResponse authentication (UserInput userInput) {
		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(userInput.getEmail(), userInput.getPassword()));
		String jwt = jwtTokenUtil.generateToken(loadUserByUsername(userInput.getEmail()));
		return new RegisterResponse(true, "token generated", null, jwt);

	}
	public RegisterResponse getAllCandidatesByUserId(Integer userId) {
			User user = userRepository.findById(userId);
			if (user != null) {
				return new RegisterResponse(true, "success", user, null);
			}
			return new RegisterResponse(false, "Check userId", null, null);
	}
	private String getHashedPassWord() {
		String pass = Utils.generateRandomPassword(5);
		logger.info("Random Password : : " + pass);
		String hashedPassword = Utils.hashPassword(pass);
		Utils.checkPass(pass, hashedPassword);
		return  (hashedPassword);
		
	}
	private User getUser(UserInput userInput) {
		User user = new User();
		user.setFirstName(userInput.getFirstName());
		user.setLastName(userInput.getLastName());
		user.setStgId(userInput.getStgId());
		user.setEmail(userInput.getEmail());
		user.setPassword(Utils.hashPassword(userInput.getPassword()));
		Role role = new Role();
		role.setCreatedAt(Utils.currentDate());
		role.setUpdatedAt(Utils.currentDate());
		role.setRoleName(userInput.getRole());
		user.setRole(role);
		user.setCreatedAt(Utils.currentDate());
		user.setUpdatedAt(Utils.currentDate());
		return user;
	}

	@Override
	public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
		User user = userRepository.findByEmail(s);
		if (user != null) {
			return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), new ArrayList<>());
		}
		return null;
	}

}

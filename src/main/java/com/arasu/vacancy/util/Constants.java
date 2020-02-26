package com.arasu.vacancy.util;

public class Constants {
	
	public static final String LOGIN = "/login";
	public static final String AUTHENTICATION = "/authentication";
	public static final String REGISTER = "/register";
	public static final String USER = "/user";
	public static final String CANDIDATE = "/candidate";
	public static final String CANDIDATE_REGISTER = "/candidate_register";
	public static final String GET_ALL_CANDIDATES = "/candidatesAll";
	public static final String GET_ALL_CANDIDATES_BY_USER_ID = "/candidatesAll/{userId}";



	/* Constants for Authentication and Authorization **/


	public static final long JWT_TOKEN_VALIDITY = 5 * 60 * 60;



}

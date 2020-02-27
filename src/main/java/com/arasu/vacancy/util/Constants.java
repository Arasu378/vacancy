package com.arasu.vacancy.util;

public class Constants {
	
	public static final String LOGIN = "/login";
	public static final String AUTHENTICATION = "/authentication";
	public static final String REGISTER = "/register";
	public static final String USER = "/user";
	public static final String CANDIDATE = "/candidate";
	public static final String SKILLS = "/skills";
	public static final String QUESTION_TYPE = "/questionType";
	public static final String CANDIDATE_REGISTER = "/candidate_register";
	public static final String SAVE_SUB_SKILL = "/saveSubSkill";
	public static final String SAVE_SKILL = "/saveSkill";
	public static final String GET_ALL_SUB_SKILL = "/subSkills";
	public static final String GET_ALL_SKILL = "/skills";
	public static final String GET_SUB_SKILL_BY_ID = "/subSkills/{subSkillId}";
	public static final String GET_SKILL_BY_ID = "/skills/{skillId}";
	public static final String GET_SUB_SKILL_BY_SKILL_ID = "/subSkills/skillId/{skillId}";
	public static final String GET_ALL_CANDIDATES = "/candidatesAll";
	public static final String GET_ALL_CANDIDATES_BY_USER_ID = "/candidatesAll/{userId}";



	/* Constants for Authentication and Authorization **/


	public static final long JWT_TOKEN_VALIDITY = 5 * 60 * 60;



}

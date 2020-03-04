package com.arasu.vacancy.util;

public class Constants {
	
	public static final String LOGIN = "/login";
	public static final String AUTHENTICATION = "/authentication";
	public static final String REGISTER = "/register";
	public static final String USER = "/user";
	public static final String CANDIDATE = "/candidate";
	public static final String SKILLS = "/skills";
	public static final String ANSWERS = "/answer";
	public static final String ANSWER_SAVE = "/save";
	public static final String ANSWER_GET_BY_ID = "/getById/{answerId}";
	public static final String ANSWER_GET_BY_QUESTION_ID = "/getByQuestionId/{questionId}";
	public static final String ANSWER_GET_ALL = "/getAll";

	public static final String QUESTION_TYPE = "/questionType";
	public static final String QUESTION = "/question";
	public static final String QUESTION_TYPE_SAVE = "/save";
	public static final String QUESTION_SAVE = "/save";
	public static final String QUESTIONS_GET_BY_ID = "/getById/{questionId}";
	public static final String QUESTIONS_GET_BY_TYPE_ID = "/getByTypeId/{typeId}";
	public static final String QUESTIONS_GET_BY_SUB_SKILL_ID = "/getByTypeId/{subSkillId}";
	public static final String QUESTIONS_GET_ALL = "/getAll";
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

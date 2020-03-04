package com.arasu.vacancy.answers.repository;

import com.arasu.vacancy.entity.QuestionAnswers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AnswerRepository  extends JpaRepository<QuestionAnswers, Integer> {

    @Query("select s from QuestionAnswers s where s.questions.questionId=:id")
    public QuestionAnswers findAnswersByQuestionId(@Param("id") Integer id);
}

package com.arasu.vacancy.questions.repository;

import com.arasu.vacancy.entity.Questions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionsRepository extends JpaRepository<Questions, Integer> {

    @Query("select s from Questions s where s.questionType.questionTypeId=:id")
    List<Questions>findByTypeId(@Param("id") Integer id);

    @Query("select s from Questions s where s.subSkill.subSkillId=:id")
    List<Questions>findBySubSkillId(@Param("id") Integer id);
    
}

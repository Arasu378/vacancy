package com.arasu.vacancy.skills.repository;

import com.arasu.vacancy.entity.SubSkill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SubSkillsRepository extends JpaRepository<SubSkill, Integer> {
    @Query("select s from SubSkill s where s.subSkillId=:id")
    SubSkill findBySubSkillId(@Param("id") Integer id);

    @Query("select s from SubSkill s where s.skill.skillId=:id")
    SubSkill findBySkillId(@Param("id") Integer id);
}

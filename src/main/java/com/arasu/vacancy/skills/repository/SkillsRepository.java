package com.arasu.vacancy.skills.repository;

import com.arasu.vacancy.entity.Skill;
import com.arasu.vacancy.entity.SubSkill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SkillsRepository extends JpaRepository<Skill, Integer> {
    @Query("select s from Skill s where s.skillId=:id")
    Skill findBySkillId(@Param("id") Integer id);

}

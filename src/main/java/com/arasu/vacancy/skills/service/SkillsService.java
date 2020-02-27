package com.arasu.vacancy.skills.service;

import com.arasu.vacancy.entity.Skill;
import com.arasu.vacancy.skills.models.SkillsInput;
import com.arasu.vacancy.skills.models.SkillsResponse;
import com.arasu.vacancy.skills.repository.SkillsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class SkillsService {

    @Autowired
    private SkillsRepository skillsRepository;

    public SkillsResponse saveSkills(SkillsInput skillsInput) {
        Skill skill = skillsRepository.save(skillData(skillsInput));
        if (skill != null) {
            return new SkillsResponse(true, "Success", skill, null);
        }
        return new SkillsResponse(false, "Failed", null, null);
    }
    public SkillsResponse getAllSkills() {
        List<Skill> skillList = skillsRepository.findAll();
        if (skillList != null) {
            return new SkillsResponse(true, "Success", null, skillList);
        }
        return new SkillsResponse(false, "Failed", null, null);
    }

    public SkillsResponse getSkillById(Integer id) {
        Skill skill = skillsRepository.findBySkillId(id);
        if (skill != null) {
            return new SkillsResponse(true, "Success", skill, null);
        }
        return new SkillsResponse(false, "Failed", null, null);
    }
    private Skill skillData(SkillsInput skillsInput) {
        Date date = new Date();
        Skill skill = new Skill();
        skill.setSkillName(skillsInput.getSkillName());
        skill.setCreatedAt(date);
        skill.setUpdatedAt(date);
        return skill;
    }


}

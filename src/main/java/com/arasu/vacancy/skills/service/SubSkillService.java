package com.arasu.vacancy.skills.service;

import com.arasu.vacancy.entity.Skill;
import com.arasu.vacancy.entity.SubSkill;
import com.arasu.vacancy.skills.models.SubSkillsInput;
import com.arasu.vacancy.skills.models.SubSkillsResponse;
import com.arasu.vacancy.skills.repository.SkillsRepository;
import com.arasu.vacancy.skills.repository.SubSkillsRepository;
import com.arasu.vacancy.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubSkillService {
    @Autowired
    private SubSkillsRepository subSkillsRepository;

    @Autowired
    private SkillsRepository skillsRepository;

    public SubSkillsResponse getAllSubSkills() {
        List<SubSkill> subSkills = subSkillsRepository.findAll();
        if (subSkills != null && subSkills.size() != 0) {
            return new SubSkillsResponse(true, "success", subSkills, null);
        }
            return new SubSkillsResponse(false, "Sub skill is empty", null, null);
    }
    public SubSkillsResponse getSubSkillById(Integer id) {
        SubSkill subSkill = subSkillsRepository.findBySubSkillId(id);
        if (subSkill != null) {
            return new SubSkillsResponse(true, "success", null, subSkill);
        }
        return new SubSkillsResponse(false, "Sub skill is empty", null, null);
    }
    public SubSkillsResponse getSubSkillBySkillId(Integer id) {
        SubSkill subSkill = subSkillsRepository.findBySkillId(id);
        if (subSkill != null) {
            return new SubSkillsResponse(true, "success", null, subSkill);
        }
        return new SubSkillsResponse(false, "Sub skill is empty", null, null);
    }

    public SubSkillsResponse saveSubSkill(SubSkillsInput subSkillsInput) {
       SubSkill subSkill =  subSkillsRepository.save(passData(subSkillsInput));
        if (subSkill != null) {
            return new SubSkillsResponse(true, "success", null, subSkill);
        }
        return new SubSkillsResponse(false, "Failed", null, null);

    }


    private SubSkill passData(SubSkillsInput subSkillsInput) {
        SubSkill subSkill = new SubSkill();
        Skill skill = skillsRepository.findBySkillId(subSkillsInput.getSkillId());
            subSkill.setSubSKillName(subSkillsInput.getName());
            subSkill.setSkill(skill);
            subSkill.setCreatedAt(Utils.currentDate());
            subSkill.setUpdatedAt(Utils.currentDate());
        return subSkill;
    }
}

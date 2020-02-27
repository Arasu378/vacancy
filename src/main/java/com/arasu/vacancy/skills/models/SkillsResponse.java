package com.arasu.vacancy.skills.models;

import com.arasu.vacancy.entity.Skill;

import java.util.List;

public class SkillsResponse {
    private Boolean isSucess;
    private String message;
    private Skill skill;
    private List<Skill>skillList;

    public SkillsResponse(Boolean isSucess, String message, Skill skill, List<Skill> skillList) {
        this.isSucess = isSucess;
        this.message = message;
        this.skill = skill;
        this.skillList = skillList;
    }

    public Boolean getSucess() {
        return isSucess;
    }

    public void setSucess(Boolean sucess) {
        isSucess = sucess;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Skill getSkill() {
        return skill;
    }

    public void setSkill(Skill skill) {
        this.skill = skill;
    }

    public List<Skill> getSkillList() {
        return skillList;
    }

    public void setSkillList(List<Skill> skillList) {
        this.skillList = skillList;
    }
}

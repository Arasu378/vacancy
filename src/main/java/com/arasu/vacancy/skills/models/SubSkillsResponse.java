package com.arasu.vacancy.skills.models;

import com.arasu.vacancy.entity.SubSkill;

import java.util.List;

public class SubSkillsResponse {
    private Boolean isSuccess;
    private String message;
    private List<SubSkill> subSkills;
    private SubSkill subSkill;

    public SubSkillsResponse(Boolean isSuccess, String message, List<SubSkill> subSkills, SubSkill subSkill) {
        this.isSuccess = isSuccess;
        this.message = message;
        this.subSkills = subSkills;
        this.subSkill = subSkill;
    }

    public Boolean getSuccess() {
        return isSuccess;
    }

    public void setSuccess(Boolean success) {
        isSuccess = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<SubSkill> getSubSkills() {
        return subSkills;
    }

    public void setSubSkills(List<SubSkill> subSkills) {
        this.subSkills = subSkills;
    }

    public SubSkill getSubSkill() {
        return subSkill;
    }

    public void setSubSkill(SubSkill subSkill) {
        this.subSkill = subSkill;
    }
}

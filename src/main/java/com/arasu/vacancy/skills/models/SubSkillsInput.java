package com.arasu.vacancy.skills.models;

public class SubSkillsInput {
    private String name;
    private Integer skillId;

    public SubSkillsInput(String name, Integer skillId) {
        this.name = name;
        this.skillId = skillId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSkillId() {
        return skillId;
    }

    public void setSkillId(Integer skillId) {
        this.skillId = skillId;
    }
}

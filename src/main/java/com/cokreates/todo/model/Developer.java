package com.cokreates.todo.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Developer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String firstName;
    private String lastName;
    private String email;

    @ManyToMany
    private List<Skill> skillList;

	public Developer() {
	}

    public Developer(String firstName, String lastName, String email, List<Skill> skillList){
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.skillList = skillList;
    }

    public List<Skill> getSkillList() {
        return skillList;
    }

    public void setSkillList(List<Skill> skillList) {
        this.skillList = skillList;
    }

    public long getId() {
        return id;
    }


    public String getFirstName() {
        return firstName;
    }


    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean hasSkill(Skill skill){
        for (Skill containedSkill: getSkillList()){
            if(containedSkill.getId() == skill.getId()){
                return true;
            }
        }
        return false;
    }
}

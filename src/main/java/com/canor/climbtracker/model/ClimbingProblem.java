package com.canor.climbtracker.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;


@Entity
public class ClimbingProblem {
    private String climbName; 
    private String grade; 
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @ManyToOne
    private Setter setter;

  

    public ClimbingProblem() {}

    public ClimbingProblem(String climbname, String grade, Integer id) {
        this.climbName = climbname; 
        this.grade = grade; 
        this.id = id;
    }

    public String getClimbName() {
        return climbName; 
    }

    public String getGrade() {
        return grade; 
    }

    public Integer getId() {
        return id; 
    }

    public Setter getSetter() {
        return setter;
    }

    public void setSetter(Setter setter) {
        this.setter = setter;
    }
    public void setClimbName(String climbName) {
        this.climbName = climbName;
    }

    public void setGrade(String grade) {
        this.grade = grade; 
    }

    public void setId(Integer id) {
        this.id = id;
    }

}

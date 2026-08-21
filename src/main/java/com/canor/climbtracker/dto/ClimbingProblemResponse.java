package com.canor.climbtracker.dto;

public class ClimbingProblemResponse {
    private Integer id; 
    private String climbName; 
    private String grade; 
    private String setterName;

    public ClimbingProblemResponse(){
        
    }

    public ClimbingProblemResponse(Integer id, String climbName, String grade, String setterName) {
        this.id = id; 
        this.climbName = climbName;
        this.grade = grade; 
        this.setterName = setterName;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setClimbName(String climbName) {
        this.climbName = climbName;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public void setSetterName(String setterName) {
        this.setterName = setterName;
    }

    public Integer getId() {
        return id;
    }

    public String getClimbName() {
        return climbName;
    }

    public String getGrade() {
        return grade;
    }

    public String getSetterName() {
        return setterName;
    }
}

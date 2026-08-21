package com.canor.climbtracker.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;

public class UpdateClimbingProblemRequest {

    @NotBlank
    private String climbName; 

    @NotBlank
    @Pattern(
        regexp = "^V(0|[1-9][0-9]*)$",
        message = "grade must start with V and contain a number 0 or greater"
    )
    private String grade; 

    @NotNull
    @Positive(message = "setterId must be positive")
    private Integer setterId;

    public UpdateClimbingProblemRequest(){}

    public UpdateClimbingProblemRequest(String climbName, String grade, Integer setterId) {
        this.climbName = climbName;
        this.grade = grade; 
        this.setterId = setterId;
    }

    public void setClimbName(String climbName) {
        this.climbName = climbName;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public void setSetterId(Integer setterId) {
        this.setterId = setterId;
    }

    public String getClimbName() {
        return climbName;
    }

    public String getGrade() {
        return grade;
    }

    public Integer getSetterId() {
        return setterId;
    }

}

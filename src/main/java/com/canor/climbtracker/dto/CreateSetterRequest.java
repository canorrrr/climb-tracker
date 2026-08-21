package com.canor.climbtracker.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

public class CreateSetterRequest {

    @NotBlank
    private String name; 

    @NotBlank
    private String climbingStyle;

    @NotNull
    @PositiveOrZero(message = "yearsSetting must be 0 or greater")
    private Integer yearsSetting;
    
    
    public CreateSetterRequest() {

    }

    public CreateSetterRequest(String name, String climbingStyle, Integer yearsSetting) {
        this.name = name; 
        this.climbingStyle = climbingStyle;
        this.yearsSetting = yearsSetting;
    }

    public String getName() {
        return name;
    }

    public String getClimbingStyle() {
        return climbingStyle;
    }

    public Integer getYearsSetting() {
        return yearsSetting;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setClimbingStyle(String climbingStyle) {
        this.climbingStyle = climbingStyle;
    }

    public void setYearsSetting(Integer yearsSetting) {
        this.yearsSetting = yearsSetting;
    }
}

package com.canor.climbtracker.dto;

import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.PositiveOrZero;

public class PatchSetterRequest {
    
    @Pattern (
        regexp = ".*\\S.*",
        message = "name must not be blank"
    )
    private String name; 

    @Pattern (
        regexp = ".*\\S.*",
        message = "climbingStyle must not be blank"
    )
    private String climbingStyle;


    @PositiveOrZero(message = "yearsSetting must be 0 or greater")
    private Integer yearsSetting; 

    public PatchSetterRequest() {

    }

    public PatchSetterRequest(String name, String climbingStyle, Integer yearsSetting) {
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

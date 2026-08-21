package com.canor.climbtracker.dto;

public class SetterResponse {
    private Integer id; 
    private String name;
    private String climbingStyle;
    private Integer yearsSetting;

    public SetterResponse() {

    }

    public SetterResponse(Integer id, String name, String climbingStyle, Integer yearsSetting) {
        this.id = id; 
        this.name = name;
        this.climbingStyle = climbingStyle;
        this.yearsSetting = yearsSetting;
    }

    public Integer getId() {
        return id; 
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

    public void setId(Integer id) {
        this.id = id; 
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

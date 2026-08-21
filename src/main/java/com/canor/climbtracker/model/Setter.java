package com.canor.climbtracker.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Setter {
    private String name; 
    private String climbingStyle;
    private int yearsSetting;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id; 

   @OneToMany(mappedBy = "setter")
   private List<ClimbingProblem> problems;


    public Setter(){}

    public Setter(String name, String climbingStyle, int yearsSetting) {
        this.name = name; 
        this.climbingStyle = climbingStyle;
        this.yearsSetting = yearsSetting;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setClimbingStyle(String climbingStyle) {
        this.climbingStyle = climbingStyle;
    }

    public void setId(Integer id) {
        this.id = id; 
    }

    public void setYearsSetting(int yearsSetting) {
        this.yearsSetting = yearsSetting;
    }

    public String getName() {
        return name;
    }

    public Integer getId() {
        return id; 
    }

    public String getClimbingStyle() {
        return climbingStyle;
    }

    public int getYearsSetting() {
        return yearsSetting;
    }
}

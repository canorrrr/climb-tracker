package com.canor.climbtracker.model;

public class Greeting {
    private String message; 
    private String climberName; 

    public Greeting (String message, String climberName) {
        this.message = message; 
        this.climberName = climberName;
    }

    public String getMessage() {
        return message; 
    }

    public String getClimberName() {
        return climberName;
    }
}

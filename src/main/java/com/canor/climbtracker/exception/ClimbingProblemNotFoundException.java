package com.canor.climbtracker.exception;

public class ClimbingProblemNotFoundException extends RuntimeException{
    
    public ClimbingProblemNotFoundException(int id) {
        super("Climbing Problem with ID " + id + " not found.");
    }
}

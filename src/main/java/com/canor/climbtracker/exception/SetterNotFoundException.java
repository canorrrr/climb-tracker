package com.canor.climbtracker.exception;

public class SetterNotFoundException extends RuntimeException {

    public SetterNotFoundException(int id) {
        super("Setter with ID " + id + " not found");
    }
    
}

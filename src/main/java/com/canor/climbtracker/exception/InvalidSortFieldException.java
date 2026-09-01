package com.canor.climbtracker.exception;

public class InvalidSortFieldException extends RuntimeException{
    public InvalidSortFieldException(String sortBy) {
        super("Invalid sort field: " + sortBy);
    }
}

package com.canor.climbtracker.exception;

public class InvalidSortDirectionException extends RuntimeException {
    public InvalidSortDirectionException(String direction) {
        super("Invalid sort direction: " + direction);
    }
}

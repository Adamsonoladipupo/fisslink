package com.fisslink.backend.exceptions;

public class NonExistingShortCodeException extends RuntimeException {
    public NonExistingShortCodeException(String message) {
        super(message);
    }
}

package com.spendster.presentation.validation;

public class ValidationResource {
    private final String message;
    private final boolean valid;

    public ValidationResource(String message, boolean valid) {
        this.message = message;
        this.valid = valid;
    }

    public String message() {
        return message;
    }

    public boolean isValid() {
        return valid;
    }
}

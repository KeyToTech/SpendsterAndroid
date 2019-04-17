package com.spendster.presentation.validation;

public class ComplexUsernameValidator implements Validation<ValidationResource> {
    private final String username;

    public ComplexUsernameValidator(String username) {
        this.username = username;
    }

    @Override
    public ValidationResource validate() {
        boolean isValid = true;
        String errorMessage = "";
        if(username.isEmpty()){
            errorMessage = "Username field is empty";
            isValid = false;
        }
        return new ValidationResource(errorMessage, isValid);
    }
}

package com.spendster.presentation.validation;

public class ComplexSimpleValidator implements Validation<ValidationResource> {
    private final String username;

    public ComplexSimpleValidator(String username) {
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

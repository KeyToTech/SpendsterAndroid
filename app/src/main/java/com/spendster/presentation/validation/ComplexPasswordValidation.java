package com.spendster.presentation.validation;

public class ComplexPasswordValidation implements Validation<ValidationResource> {
    private final String password;

    public ComplexPasswordValidation(String password) {
        this.password = password;
    }

    @Override
    public ValidationResource validate() {
        boolean isValid = true;
        String errorMessage = "";
        if(password.isEmpty()){
            errorMessage = "Password field is empty";
            isValid = false;
        }
        return new ValidationResource(errorMessage, isValid);
    }
}

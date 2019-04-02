package com.spendster.presentation.validation;

public class ComplexEmailValidator implements Validation<ValidationResource> {
    private final String email;

    public ComplexEmailValidator(String email) {
        this.email = email;
    }

    @Override
    public ValidationResource validate() {
        boolean isValid = true;
        String errorMessage = "";
        if(this.email.isEmpty()){
            errorMessage = "Email field is empty";
            isValid = false;
        }
        else if (!this.email.contains("@")){
            errorMessage = "Email must contain @ symbol";
            isValid = false;
        }
        return new ValidationResource(errorMessage, isValid);
    }
}

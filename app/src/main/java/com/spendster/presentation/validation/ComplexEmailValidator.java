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
        else if (!this.email.matches(".*@.*")){
            errorMessage = "Email must contain @ symbol";
            isValid = false;
        }else if (!this.email.matches("^[a-zA-Z\\d_-]+@.+")){
            errorMessage = "Email must contain text before @ symbol";
            isValid = false;
        }else if (!this.email.matches(".+@[a-zA-Z\\d_\\-\\.]+")) {
            errorMessage = "Email must contain text after @ symbol";
            isValid = false;
        }else if (!this.email.matches("^[a-zA-Z\\d_-]+@[a-zA-Z\\d_-]+\\..+")) {
            errorMessage = "Email must contain something like .com";
            isValid = false;
        }
        return new ValidationResource(errorMessage, isValid);
    }
}

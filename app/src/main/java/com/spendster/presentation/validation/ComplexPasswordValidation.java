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
        }else if(!password.matches("\\w{8,16}")){
            errorMessage = "Password must contain from 8 to 16 symbols";
            isValid = false;
        }
        return new ValidationResource(errorMessage, isValid);
    }
}

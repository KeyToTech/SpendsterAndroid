package com.spendster.presentation.validation;

public class ComplexSimpleValidator implements Validation<ValidationResource> {
    private final String username;
    private final String CORRECT_SYMBOLS = "\\w+";

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
        }if(!username.matches(CORRECT_SYMBOLS)){
            errorMessage = "Forbidden symbols in username";
            isValid = false;
        }
        return new ValidationResource(errorMessage, isValid);
    }
}

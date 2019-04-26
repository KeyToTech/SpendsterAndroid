package com.spendster.presentation.validation;

public class ComplexEmailValidator implements Validation<ValidationResource> {
    private final String email;
    private final String CONTAIN_AT = ".*@.*";
    private final String CONTAIN_TEXT_BEFORE_AT = "^[a-zA-Z\\d_-]+@.+";
    private final String CONTAIN_TEXT_AFTER_AT = ".+@[a-zA-Z\\d_\\-\\.]+";
    private final String CONTAIN_ENDING = "^[a-zA-Z\\d_-]+@[a-zA-Z\\d_-]+\\..+";

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
        else if (!this.email.matches(CONTAIN_AT)){
            errorMessage = "Email must contain @ symbol";
            isValid = false;
        }else if (!this.email.matches(CONTAIN_TEXT_BEFORE_AT)){
            errorMessage = "Email must contain text before @ symbol";
            isValid = false;
        }else if (!this.email.matches(CONTAIN_TEXT_AFTER_AT)) {
            errorMessage = "Email must contain text after @ symbol";
            isValid = false;
        }else if (!this.email.matches(CONTAIN_ENDING)) {
            errorMessage = "Email must contain something like .com";
            isValid = false;
        }
        return new ValidationResource(errorMessage, isValid);
    }
}

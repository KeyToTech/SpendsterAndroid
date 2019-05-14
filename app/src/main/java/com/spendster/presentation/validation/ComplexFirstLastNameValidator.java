package com.spendster.presentation.validation;

public class ComplexFirstLastNameValidator implements Validation<ValidationResource>{

    private String firstLastName;

    public ComplexFirstLastNameValidator(String firstLastName) {
        this.firstLastName = firstLastName;
    }

    @Override
    public ValidationResource validate() {
        boolean isValid = true;
        String errorMessage = "";
        if(this.firstLastName.isEmpty()){
            errorMessage = "First and Last name field is empty";
            isValid = false;
        }
        else if (!this.firstLastName.contains(" ")){
            errorMessage = "Input Last name";
            isValid = false;
        }
        return new ValidationResource(errorMessage, isValid);
    }
}

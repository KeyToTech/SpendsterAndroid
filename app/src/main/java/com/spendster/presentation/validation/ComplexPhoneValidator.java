package com.spendster.presentation.validation;

public class ComplexPhoneValidator implements Validation<ValidationResource>  {
    private String phone;

    public ComplexPhoneValidator(String phone) {
        this.phone = phone;
    }

    @Override
    public ValidationResource validate() {
        boolean isValid = true;
        String errorMessage = "";
        if(this.phone.isEmpty()){
            errorMessage = "First and Last name field is empty";
            isValid = false;
        }
        return new ValidationResource(errorMessage, isValid);
    }
}

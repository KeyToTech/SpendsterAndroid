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
        else if (this.phone.length() < 10){
            errorMessage = "Phone number is too short";
            isValid = false;
        }
        else if (this.phone.length() > 10){
            errorMessage = "Phone number is too long";
            isValid = false;
        }
        return new ValidationResource(errorMessage, isValid);
    }
}

package com.spendster.presentation.validation;

public class ComplexPhoneValidator implements Validation<ValidationResource> {
    private String phone;

    public ComplexPhoneValidator(String phone) {
        this.phone = phone;
    }

    @Override
    public ValidationResource validate() {
        boolean isValid = true;
        String errorMessage = "";
        if (this.phone.isEmpty()) {
            errorMessage = "Phone field is empty";
            isValid = false;
        } else if (((Character) this.phone.charAt(0)).equals("+")){
            errorMessage = "Phone number must begins with +";
            isValid = false;
        } else if (this.phone.length() != 13){
            errorMessage = "Incorrect amount of digits";
            isValid = false;
        }
        return new ValidationResource(errorMessage, isValid);
    }
}

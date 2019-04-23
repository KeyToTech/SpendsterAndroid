package com.spendster.presentation.validation;

public class ComplexAddressValidator implements Validation<ValidationResource>  {
    private String address;

    public ComplexAddressValidator(String address) {
        this.address = address;
    }

    @Override
    public ValidationResource validate() {
        boolean isValid = true;
        String errorMessage = "";
        if(this.address.isEmpty()){
            errorMessage = "Address field is empty";
            isValid = false;
        }
        return new ValidationResource(errorMessage, isValid);
    }
}

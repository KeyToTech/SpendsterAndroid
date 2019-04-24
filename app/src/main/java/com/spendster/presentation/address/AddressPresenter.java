package com.spendster.presentation.address;

import com.spendster.presentation.validation.ComplexAddressValidator;
import com.spendster.presentation.validation.ComplexFirstLastNameValidator;
import com.spendster.presentation.validation.ComplexPhoneValidator;
import com.spendster.presentation.validation.ValidationResource;

public class AddressPresenter{

    private AddressView addressView;

    public AddressPresenter(AddressView addressView) {
        this.addressView = addressView;
    }

    public void setAddress(String fLName, String phone, String address){
        ValidationResource fNNameValidation = new ComplexFirstLastNameValidator(fLName).validate();
        ValidationResource phoneValidation = new ComplexPhoneValidator(phone).validate();
        ValidationResource addressValidation = new ComplexAddressValidator(address).validate();

        if (!fNNameValidation.isValid()) {
            if (addressView != null) {
                addressView.showError(fNNameValidation.message());
            }
        } else if (!phoneValidation.isValid()) {
            if (addressView != null) {
                addressView.showError(phoneValidation.message());
            }
        }else if (!addressValidation.isValid()) {
            if (addressView != null) {
                addressView.showError(addressValidation.message());
            }
        } else {
            addressView.showNextScreen();
        }
    }
}

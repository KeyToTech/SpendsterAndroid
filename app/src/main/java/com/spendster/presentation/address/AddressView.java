package com.spendster.presentation.address;

public interface AddressView {
    void showFirstLastNameError(String message);

    void showAddressError(String message);

    void showPhoneError(String message);

    void showNextScreen();
}

package com.spendster.presentation.authentication;

public interface AuthView {
    void showNextActivity();

    void showEmailError(String message);

    void showPasswordError(String message);

}

package com.spendster.presentation;

public interface AuthView {
    void showNextActivity();

    void showEmailError(String message);

    void showPasswordError(String message);

}

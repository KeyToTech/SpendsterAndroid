package com.spendster.presentation.signUp;

public interface SignUpView {
    void showNextActivity();

    void showEmailError(String message);

    void showPasswordError(String message);

    void showRetypePasswordError(String message);
}

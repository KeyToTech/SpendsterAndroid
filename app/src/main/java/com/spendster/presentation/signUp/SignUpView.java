package com.spendster.presentation.signUp;

import com.spendster.presentation.AuthView;

public interface SignUpView extends AuthView {
    @Override
    void showNextActivity();

    @Override
    void showEmailError(String message);

    @Override
    void showPasswordError(String message);

    void showRetypePasswordError(String message);
}

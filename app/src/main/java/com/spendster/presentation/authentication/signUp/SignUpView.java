package com.spendster.presentation.authentication.signUp;

import com.spendster.presentation.authentication.AuthView;

public interface SignUpView extends AuthView {
    void showRetypePasswordError(String message);
}

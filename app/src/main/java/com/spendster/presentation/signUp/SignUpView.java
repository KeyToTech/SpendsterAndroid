package com.spendster.presentation.signUp;

import com.spendster.presentation.AuthView;

public interface SignUpView extends AuthView {
    void showRetypePasswordError(String message);
    void showUsernameError(String message);
}

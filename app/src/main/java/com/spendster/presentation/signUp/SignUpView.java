package com.spendster.presentation.signUp;

public interface SignUpView {
    void showNextActivity();

    void showEmailAtError();

    void showEmailIsEmptyError();

    void showPasswordIsEmptyError();

    void showPasswordNotEqualError();
}

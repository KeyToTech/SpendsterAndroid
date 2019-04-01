package com.spendster.presentation.signUp;

public interface SignUpLoginView {
    void showNextActivity();

    void showEmailAtError();

    void showEmailIsEmptyError();

    void showPasswordIsEmptyError();

    void showPasswordNotEqualError();
}

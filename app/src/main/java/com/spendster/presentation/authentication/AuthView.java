package com.spendster.presentation.authentication;

import com.spendster.presentation.LoadingView;

public interface AuthView extends LoadingView {
    void showNextActivity();

    void showError(String message);
}

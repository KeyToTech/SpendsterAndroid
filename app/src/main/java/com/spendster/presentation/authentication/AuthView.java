package com.spendster.presentation.authentication;

import com.spendster.presentation.ErrorsView;
import com.spendster.presentation.LoadingView;

public interface AuthView extends ErrorsView, LoadingView  {
    void showNextScreen();
    void launchPreviousScreen();
}

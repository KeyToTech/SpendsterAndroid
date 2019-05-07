package com.spendster.presentation.launchScreen;

import com.spendster.presentation.authentication.SUserStorage;

public class LaunchPresenter {
    private LaunchView launchView;
    private SUserStorage sUserStorage;

    public LaunchPresenter(LaunchView launchView, SUserStorage sUserStorage) {
        this.launchView = launchView;
        this.sUserStorage = sUserStorage;
    }

    public void startBeginningScreen(){
        if (sUserStorage.userExist()){
            launchView.startHomeScreen();
        } else {
            launchView.startWelcomeScreen();
        }
    }
}

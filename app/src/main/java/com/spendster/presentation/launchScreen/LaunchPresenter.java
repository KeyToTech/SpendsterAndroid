package com.spendster.presentation.launchScreen;

import android.os.Handler;

import com.spendster.presentation.authentication.SUserStorage;

public class LaunchPresenter {
    private LaunchView launchView;
    private SUserStorage sUserStorage;

    public LaunchPresenter(LaunchView launchView, SUserStorage sUserStorage) {
        this.launchView = launchView;
        this.sUserStorage = sUserStorage;
    }

    public void startBeginningScreen(){
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (sUserStorage.userExist()){
                    launchView.startHomeScreen();
                } else {
                    launchView.startWelcomeScreen();
                }
            }
        }, 100);
    }
}

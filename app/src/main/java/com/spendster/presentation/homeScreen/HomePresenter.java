package com.spendster.presentation.homeScreen;

import android.content.Context;
import com.spendster.presentation.authentication.SharedPreferencesUserStorage;

public class HomePresenter {

    private final HomeView homeView;
    private final Context context;

    public HomePresenter(HomeView homeView, Context context) {
        this.homeView = homeView;
        this.context = context;
    }

    public void logOut(){
        clearData();
        homeView.goToWelcomeScreen();
    }

    private void clearData(){
        SharedPreferencesUserStorage sharedPreferencesUserStorage = new
                SharedPreferencesUserStorage(context);
        sharedPreferencesUserStorage.clear();
    }
}

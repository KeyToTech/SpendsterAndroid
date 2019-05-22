package com.spendster.presentation.homeScreen.Profile;

import android.util.Log;

import com.spendster.data.entity.User;
import com.spendster.presentation.authentication.SharedPreferencesUserStorage;

public class ProfilePresenter {
    private ProfileView profileView;
    private SharedPreferencesUserStorage sharedPreferencesUserStorage;

    public ProfilePresenter(ProfileView profileView, SharedPreferencesUserStorage
            sharedPreferencesUserStorage) {
        this.profileView = profileView;
        this.sharedPreferencesUserStorage = sharedPreferencesUserStorage;
    }

    public void fillProfileFields() {
        User user = sharedPreferencesUserStorage.read();
        if (user != null){
            profileView.fillUserFields(user);
        }else {
            Log.d("MyLogs", "User is empty");
            //TODO: https://trello.com/c/EdvlWVBo/165-log-out-in-profilepresenter
        }
    }
}

package com.spendster.presentation.homeScreen.Profile;

import com.spendster.data.entity.User;
import com.spendster.presentation.authentication.SharedPreferencesUserStorage;

public class ProfilePresenter {
    private ProfileFragmentView profileFragmentView;
    private SharedPreferencesUserStorage sharedPreferencesUserStorage;

    public ProfilePresenter(ProfileFragmentView profileFragmentView, SharedPreferencesUserStorage
            sharedPreferencesUserStorage) {
        this.profileFragmentView = profileFragmentView;
        this.sharedPreferencesUserStorage = sharedPreferencesUserStorage;
    }

    public void fillProfileFields() {
        User user = sharedPreferencesUserStorage.read();
        if (!user.getEmail().isEmpty()) {
            profileFragmentView.setEmail(user.getEmail());
        }
        if (!user.getUsername().isEmpty()) {
            profileFragmentView.setUsername(user.getUsername());
        }
    }
}

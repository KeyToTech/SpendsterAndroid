package com.spendster.presentation.launchScreen;

import android.content.Intent;
import android.os.Bundle;

import com.spendster.R;
import com.spendster.presentation.authentication.SharedPreferencesUserStorage;
import com.spendster.presentation.homeScreen.HomeActivity;
import com.spendster.presentation.welcomeScreen.WelcomeActivity;

import androidx.appcompat.app.AppCompatActivity;

public class LaunchActivity extends AppCompatActivity implements LaunchView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch);

        final LaunchPresenter launchPresenter = new LaunchPresenter(this,
                new SharedPreferencesUserStorage(getBaseContext()));
        launchPresenter.startBeginningScreen();
    }

    @Override
    public void startHomeScreen(){
        finish();
        startActivity(new Intent(LaunchActivity.this, HomeActivity.class));
    }

    @Override
    public void startWelcomeScreen(){
        finish();
        startActivity(new Intent(LaunchActivity.this, WelcomeActivity.class));
    }
}

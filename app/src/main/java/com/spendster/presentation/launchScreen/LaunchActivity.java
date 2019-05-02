package com.spendster.presentation.launchScreen;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.spendster.R;
import com.spendster.presentation.homeScreen.HomeActivity;
import com.spendster.presentation.welcomeScreen.WelcomeActivity;

public class LaunchActivity extends AppCompatActivity {

    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch);

        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                startBeginningScreen();
            }
        }, 100);
    }

    private void startBeginningScreen() {
        sharedPreferences = getSharedPreferences( "mysettings", MODE_PRIVATE);
        boolean isUserExist = sharedPreferences.getBoolean("user_saved", false);
        if (isUserExist){
            startHomeScreen();
        } else {
            startWelcomeScreen();
        }
    }

    private void startHomeScreen(){
        startActivity(new Intent(LaunchActivity.this, HomeActivity.class));
    }

    private void startWelcomeScreen(){
        startActivity(new Intent(LaunchActivity.this, WelcomeActivity.class));
    }
}

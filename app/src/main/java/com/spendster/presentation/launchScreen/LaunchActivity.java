package com.spendster.presentation.launchScreen;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.spendster.R;
import com.spendster.presentation.homeScreen.HomeActivity;

public class LaunchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch);

        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                startHomeScreen();
            }
        }, 100);
    }

    private void startHomeScreen(){
        startActivity(new Intent(LaunchActivity.this, HomeActivity.class));
    }
}

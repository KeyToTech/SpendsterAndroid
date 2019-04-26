package com.spendster.presentation.authentication.login;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.spendster.R;
import com.spendster.presentation.authentication.APIClient;
import com.spendster.presentation.authentication.AuthView;
import com.spendster.presentation.homeScreen.HomeActivity;

public class LoginActivity extends AppCompatActivity implements AuthView {

    private LoginPresenter loginPresenter;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        loginPresenter = new LoginPresenter(this, new SimpleLoginModel(APIClient.getClient().create(APILogin.class)));
        initUI();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        loginPresenter.dispose();
    }

    private void initUI(){
        final Button btnContinue = findViewById(R.id.btnContinue);
        final EditText etEmail = findViewById(R.id.etEmail);
        final EditText etPassword = findViewById(R.id.etPassword);

        btnContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = etEmail.getText().toString();
                String password = etPassword.getText().toString();
                loginPresenter.login(email, password);
            }
        });
    }

    private void saveAuthUser(){
        sharedPreferences = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean("user_saved", true);
        editor.apply();
    }

    @Override
    public void showNextActivity() {
        saveAuthUser();
        startActivity(new Intent(LoginActivity.this, HomeActivity.class));
    }

    @Override
    public void showError(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}

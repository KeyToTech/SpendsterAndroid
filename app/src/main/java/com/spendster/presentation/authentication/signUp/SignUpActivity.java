package com.spendster.presentation.authentication.signUp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.spendster.BuildConfig;
import com.spendster.R;
import com.spendster.presentation.authentication.APIClient;
import com.spendster.presentation.authentication.AuthView;
import com.spendster.presentation.moreAboutYou.MoreAboutYouActivity;

public class SignUpActivity extends AppCompatActivity implements AuthView {

    private SignUpPresenter signUpPresenter;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        signUpPresenter = new SignUpPresenter(this, new SimpleSignUpModel(APIClient.getClient().create(APISignUp.class)));
        initIU();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        signUpPresenter.dispose();
    }

    private void initIU(){
        final Button btnContinue = findViewById(R.id.btnContinue);
        final EditText etEmail = findViewById(R.id.etEmail);
        final EditText etPassword = findViewById(R.id.etPassword);
        final EditText etRetypePassword = findViewById(R.id.etRetypePassword);
        final EditText etUserName = findViewById(R.id.etUserName);

        btnContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = etEmail.getText().toString();
                String password = etPassword.getText().toString();
                String retypePassword = etRetypePassword.getText().toString();
                String username = etUserName.getText().toString();
                signUpPresenter.signUp(email, password, retypePassword, username);
            }
        });
    }

    private void saveAuthUser(){
        sharedPreferences = getSharedPreferences(BuildConfig.USER_EXIST, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(BuildConfig.USER_SAVED, true);
        editor.apply();
    }

    @Override
    public void showNextActivity() {
        saveAuthUser();
        startActivity(new Intent(this, MoreAboutYouActivity.class));
    }

    @Override
    public void showError(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}

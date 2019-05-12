package com.spendster.presentation.authentication.signUp;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.spendster.R;
import com.spendster.presentation.authentication.APIClient;
import com.spendster.presentation.authentication.AuthView;
import com.spendster.presentation.authentication.SharedPreferencesUserStorage;
import com.spendster.presentation.moreAboutYou.MoreAboutYouActivity;

public class SignUpActivity extends AppCompatActivity implements AuthView {

    private SignUpPresenter signUpPresenter;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        signUpPresenter = new SignUpPresenter(new SharedPreferencesUserStorage(getBaseContext()),
                this, new SimpleSignUpModel(APIClient.getClient().create(APISignUp.class)));
        initIU();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        signUpPresenter.dispose();
    }

    private void initIU() {
        progressDialog = new ProgressDialog(this, ProgressDialog.THEME_HOLO_DARK);
        progressDialog.setMessage("Signing up. Please wait.");
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

    @Override
    public void showNextActivity() {
        finish();
        startActivity(new Intent(this, MoreAboutYouActivity.class));
    }

    @Override
    public void showError(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showLoading() {
        progressDialog.show();
    }

    @Override
    public void hideLoading() {
        progressDialog.dismiss();
    }
}
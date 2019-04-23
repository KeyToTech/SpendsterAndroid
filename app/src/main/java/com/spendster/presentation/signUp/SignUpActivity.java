package com.spendster.presentation.signUp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.spendster.BuildConfig;
import com.spendster.R;
import com.spendster.presentation.AuthView;
import com.spendster.presentation.moreAboutYou.MoreAboutYouActivity;

public class SignUpActivity extends AppCompatActivity implements AuthView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        final Button btnContinue = findViewById(R.id.btnContinue);
        final EditText etEmail = findViewById(R.id.etEmail);
        final EditText etPassword = findViewById(R.id.etPassword);
        final EditText etRetypePassword = findViewById(R.id.etRetypePassword);
        final EditText etUserName = findViewById(R.id.etUserName);

        final SignUpPresenter signUpPresenter = new SignUpPresenter(this, new ServerSignUpModel());

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
        Intent intent = new Intent(this, MoreAboutYouActivity.class);
        startActivity(intent);
    }

    @Override
    public void showError(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}

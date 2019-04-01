package com.spendster.presentation.signUp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.spendster.R;

public class SignUpActivity extends AppCompatActivity implements SignUpLoginView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        final SignUpPresenter signUpPresenter = new SignUpPresenter(this);
        final Button btnContinue = findViewById(R.id.btnContinue);
        final EditText etEmail = findViewById(R.id.etEmail);
        final EditText etPassword = findViewById(R.id.etPassword);
        final EditText etRetypePassword = findViewById(R.id.etRetypePassword);

        btnContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = etEmail.getText().toString();
                String password = etPassword.getText().toString();
                String retypePassword = etRetypePassword.getText().toString();
                signUpPresenter.validation(email, password, retypePassword);
            }
        });
    }

    @Override
    public void showNextActivity() {

    }

    @Override
    public void showEmailAtError() {
        Toast.makeText(this,"Email must contain @ symbol", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showEmailIsEmptyError() {
        Toast.makeText(this,"Email field is empty", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showPasswordNotEqualError() {
        Toast.makeText(this,"Passwords is not equal", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showPasswordIsEmptyError() {
        Toast.makeText(this,"Password field is empty", Toast.LENGTH_SHORT).show();
    }
}

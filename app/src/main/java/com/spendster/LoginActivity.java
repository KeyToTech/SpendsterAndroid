package com.spendster;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private EditText etEmail;
    private EditText etPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Button btLogin = findViewById(R.id.btLogin);
        this.etEmail = findViewById(R.id.etEmail);
        this.etPassword = findViewById(R.id.etPassword);

        btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = email();
                String password = password();
                if(emailIsValid(email) && passwordIsValid(password)) {
                    showApprovingAnswer();
                } else if(!emailIsValid(email)){
                    showInvalidEmail();
                } else {
                    showInvalidPassword();
                }
            }
        });
    }

    private void showInvalidPassword() {
        Toast.makeText(this, "Invalid Password", Toast.LENGTH_SHORT).show();
    }

    private void showInvalidEmail() {
        Toast.makeText(this, "Invalid Email", Toast.LENGTH_SHORT).show();
    }

    private boolean passwordIsValid(String password) {
        return !password.isEmpty() && password != null;
    }

    private boolean emailIsValid(String email) {
        return email != null && !email.isEmpty();
    }

    private void showApprovingAnswer() {
        Intent intent = new Intent(this, TempActivity.class);
        startActivity(intent);
    }

    private String email() {
        return this.etEmail.getText().toString();
    }

    private String password() {
        return this.etPassword.getText().toString();
    }
}



package com.spendster.presentation.login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.spendster.R;
import com.spendster.presentation.TempActivity;

public class LoginActivity extends AppCompatActivity implements LoginView{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Button btLogin = findViewById(R.id.btLogin);
        final EditText etEmail = findViewById(R.id.etEmail);
        final EditText etPassword = findViewById(R.id.etPassword);

        final LoginPresenter loginPresenter = new LoginPresenter(new FkLoginModel(), this);

        btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginPresenter.checkFunc(etEmail.getText().toString(), etPassword.getText().toString());
            }
        });
    }

    public void showNextActivity(){
        Intent intent = new Intent(this, TempActivity.class);
        startActivity(intent);
    }

    public void showEmailError(){
        Toast.makeText(this, "Invalid Email", Toast.LENGTH_SHORT).show();
    }

    public void showPasswordError(){
        Toast.makeText(this, "Invalid Password", Toast.LENGTH_SHORT).show();
    }
}

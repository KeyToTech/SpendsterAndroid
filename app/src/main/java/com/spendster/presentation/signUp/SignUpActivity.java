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
import com.spendster.presentation.moreAboutYou.MoreAboutYouActivity;

public class SignUpActivity extends AppCompatActivity implements SignUpView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        final SignUpPresenter signUpPresenter = new SignUpPresenter(this, new ServerSignUpModel());
        final Button btnContinue = findViewById(R.id.btnContinue);
        final EditText etEmail = findViewById(R.id.etEmail);
        final EditText etPassword = findViewById(R.id.etPassword);
        final EditText etRetypePassword = findViewById(R.id.etRetypePassword);

        if(BuildConfig.DEBUG){
            etEmail.setText("test@gmail.com");
            etPassword.setText("12345678");
            etRetypePassword.setText("12345678");
        }

        btnContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = etEmail.getText().toString();
                String password = etPassword.getText().toString();
                String retypePassword = etRetypePassword.getText().toString();
                signUpPresenter.signUp(email, password, retypePassword);
            }
        });
    }

    @Override
    public void showNextActivity() {
        Intent intent = new Intent(this, MoreAboutYouActivity.class);
        startActivity(intent);
    }

    @Override
    public void showEmailError(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showPasswordError(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showRetypePasswordError(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}

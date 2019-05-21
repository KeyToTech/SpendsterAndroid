package com.spendster.presentation.address;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.spendster.R;
import com.spendster.presentation.homeScreen.HomeActivity;

import androidx.appcompat.app.AppCompatActivity;

public class AddressActivity extends AppCompatActivity implements AddressView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adress);

        initUI();
    }

    private void initUI(){
        final EditText etFLName = findViewById(R.id.etFLName);
        final EditText etPhone = findViewById(R.id.etPhone);
        final EditText etAddress = findViewById(R.id.etAddress);

        final Button btnGetStarted = findViewById(R.id.btnGetStarted);

        final AddressPresenter addressPresenter = new AddressPresenter(this);

        btnGetStarted.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String fLName = etFLName.getText().toString();
                String phone = etPhone.getText().toString();
                String address = etAddress.getText().toString();

                addressPresenter.setAddress(fLName, phone, address);
            }
        });
    }

    @Override
    public void showError(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showNextScreen() {
        startActivity(new Intent(this, HomeActivity.class));
    }
}

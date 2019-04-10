package com.spendster.presentation.moreAboutYou;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.spendster.R;
import com.spendster.presentation.address.AddressActivity;

public class MoreAboutYouActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more_about_you);

        final Button btnContinue = findViewById(R.id.btnContinue);
        final Button btnMaybeLater = findViewById(R.id.btnMaybeLater);
        final Button btnCamera = findViewById(R.id.btnCamera);

        btnContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launchAddressScreen();
            }
        });
        btnMaybeLater.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launchMainActivity();
            }
        });
        btnCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivityForResult(new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.INTERNAL_CONTENT_URI), 3);
            }
        });
    }

    private void launchMainActivity() { Toast.makeText(this, "Main screen", Toast.LENGTH_SHORT).show(); }

    private void launchAddressScreen() {
        startActivity(new Intent(this, AddressActivity.class));
    }
}

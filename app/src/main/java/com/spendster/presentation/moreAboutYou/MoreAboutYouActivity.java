package com.spendster.presentation.moreAboutYou;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.spendster.R;
import com.spendster.presentation.address.AddressActivity;
import com.spendster.presentation.homeScreen.HomeActivity;

import java.io.IOException;
import java.util.Objects;

public class MoreAboutYouActivity extends AppCompatActivity {
    private final int CAMERA_REQUEST_CODE = 3000;
    private final int GALLERY = 1;
    private final int CAMERA = 2;
    private ImageView imageAvatar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more_about_you);

        final Button btnContinue = findViewById(R.id.btnContinue);
        final Button btnMaybeLater = findViewById(R.id.btnMaybeLater);
        final Button btnCamera = findViewById(R.id.btnCamera);
        imageAvatar = findViewById(R.id.cat);

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
                showPictureDialog();
            }
        });
    }


    private void launchMainActivity() {
        startActivity(new Intent(this, HomeActivity.class));
    }

    private void launchAddressScreen() {
        startActivity(new Intent(this, AddressActivity.class));
    }

    private void showPictureDialog() {
        AlertDialog.Builder pictureDialog = new AlertDialog.Builder(this);
        pictureDialog.setTitle(R.string.select_action);
        String[] pictureDialogItems = {
                getString(R.string.select_photo_from_gallery),
                getString(R.string.capture_photo_from_camera)};
        pictureDialog.setItems(pictureDialogItems,
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        switch (which) {
                            case 0:
                                choosePhotoFromGallery();
                                break;
                            case 1:
                                takePhotoFromCamera();
                                break;
                        }
                    }
                });
        pictureDialog.show();
    }

    public void choosePhotoFromGallery() {
        Intent galleryIntent = new Intent(Intent.ACTION_PICK,
                android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(galleryIntent, GALLERY);
    }

    private void takePhotoFromCamera() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (checkSelfPermission(Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED) {
                startActivityForResult(new Intent(MediaStore.ACTION_IMAGE_CAPTURE), CAMERA);
            } else {
                String[] permissionRequested = {Manifest.permission.CAMERA};
                requestPermissions(permissionRequested, CAMERA_REQUEST_CODE);
            }
        }else {
            Toast.makeText(this, getString(R.string.version_error), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == CAMERA_REQUEST_CODE) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                takePhotoFromCamera();
            }
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_CANCELED) {
            Toast.makeText(this, getString(R.string.version_error), Toast.LENGTH_SHORT).show();
        }
        if (requestCode == GALLERY) {
            if (data != null) {
                Uri contentURI = data.getData();
                try {
                    Bitmap bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(),
                            contentURI);
                    imageAvatar.setImageBitmap(bitmap);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        } else if (requestCode == CAMERA) {
            Bitmap thumbnail = null;
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.KITKAT) {
                thumbnail = (Bitmap) Objects.requireNonNull(data.getExtras()).get("data");
            }else {
                Toast.makeText(this, getString(R.string.version_error), Toast.LENGTH_SHORT).show();
            }
            imageAvatar.setImageBitmap(thumbnail);
        }
    }
}

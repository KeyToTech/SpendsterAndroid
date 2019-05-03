package com.spendster.presentation.homeScreen;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.spendster.R;

public class ProfileFragment extends Fragment {

    private EditText etUsername, etProfileEmail;

    public static ProfileFragment newInstance(){
        return new ProfileFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.profile_fragment, container, false);
        etUsername = view.findViewById(R.id.etUsername);
        etProfileEmail = view.findViewById(R.id.etProfileEmail);
        etUsername.setText("Loh Cvetochnyi");
        etProfileEmail.setText("svatoslavmaga@gamil.com");
        return view;
    }
}

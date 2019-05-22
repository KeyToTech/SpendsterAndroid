package com.spendster.presentation.homeScreen.Profile;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.spendster.R;
import com.spendster.data.entity.User;
import com.spendster.presentation.authentication.SharedPreferencesUserStorage;

import java.util.Objects;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

public class ProfileFragment extends Fragment implements ProfileView {

    private EditText etUsername, etProfileEmail;

    public static ProfileFragment newInstance() {
        return new ProfileFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.profile_fragment, container, false);
        initUI(view);
        new ProfilePresenter(this, new
                SharedPreferencesUserStorage(Objects.requireNonNull(getContext()))).fillProfileFields();
        return view;
    }

    private void initUI(View view) {
        etUsername = view.findViewById(R.id.etUsername);
        etProfileEmail = view.findViewById(R.id.etProfileEmail);
    }

    @Override
    public void fillUserFields(@NonNull User user) {
        etUsername.setText(user.getUsername());
        etProfileEmail.setText(user.getEmail());
    }
}

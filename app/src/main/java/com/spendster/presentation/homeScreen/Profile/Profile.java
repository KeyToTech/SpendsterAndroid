package com.spendster.presentation.homeScreen.Profile;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.spendster.R;
import com.spendster.data.entity.User;
import com.spendster.presentation.authentication.SharedPreferencesUserStorage;

public class Profile extends Fragment implements ProfileView {

    private EditText etUsername, etProfileEmail;

    public static Profile newInstance() {
        return new Profile();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.profile_fragment, container, false);
        etUsername = view.findViewById(R.id.etUsername);
        etProfileEmail = view.findViewById(R.id.etProfileEmail);
        initUI();
        return view;
    }

    private void initUI() {
        final ProfilePresenter profilePresenter = new ProfilePresenter(this, new
                SharedPreferencesUserStorage(getContext()));
        profilePresenter.fillProfileFields();
    }

    @Override
    public void fillUserFields(User user) {
        etUsername.setText(user.getUsername());
        etProfileEmail.setText(user.getEmail());
    }
}

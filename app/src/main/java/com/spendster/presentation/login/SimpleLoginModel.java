package com.spendster.presentation.login;

import com.spendster.data.entity.User;
import com.spendster.presentation.login.LoginModel;

public class SimpleLoginModel implements LoginModel {
    private final String email;
    private final String password;

    public SimpleLoginModel(String email, String password) {
        this.email = email;
        this.password = password;
    }

    @Override
    public User login(String email) {
        throw new UnsupportedOperationException("Not implemented yet");
    }
}

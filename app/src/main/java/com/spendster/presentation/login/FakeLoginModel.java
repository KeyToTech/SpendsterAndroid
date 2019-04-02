package com.spendster.presentation.login;

import com.spendster.data.entity.User;

public class FakeLoginModel implements LoginModel {
    @Override
    public User getUser(String email, String password) {
        return new User(1234, "Ihor");
    }
}

package com.spendster.presentation.login;

import com.spendster.data.entity.User;

import io.reactivex.Single;

public class FakeLoginModel implements LoginModel {
    @Override
    public Single<User> login(String email, String password) {
        return null;
    }
}

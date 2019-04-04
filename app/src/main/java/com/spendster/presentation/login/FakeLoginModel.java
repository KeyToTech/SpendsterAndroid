package com.spendster.presentation.login;

import com.spendster.data.entity.User;

import io.reactivex.Single;

public class FakeLoginModel implements LoginModel {
    @Override
    public Single<User> getUser(String email, String password) {
        return Single.just(new User(1234, "Ihor"));
    }
}

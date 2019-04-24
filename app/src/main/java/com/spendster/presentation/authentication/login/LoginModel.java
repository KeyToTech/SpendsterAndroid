package com.spendster.presentation.authentication.login;

import com.spendster.data.entity.User;

import io.reactivex.Single;

public interface LoginModel {
    Single<User> login(String email, String password);
}

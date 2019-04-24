package com.spendster.presentation.authentication.login;

import com.spendster.data.entity.User;

import io.reactivex.Single;

public class SimpleLoginModel implements LoginModel {

    private APILogin apiLogin;

    public SimpleLoginModel(APILogin apiLogin) {
        this.apiLogin = apiLogin;
    }

    @Override
    public Single<User> login(String email, String password) {
        return apiLogin.login(new User(email, password));
    }
}

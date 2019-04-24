package com.spendster.presentation.login;

import com.spendster.data.entity.User;
import com.spendster.presentation.APIClient;

import io.reactivex.Single;

public class SimpleLoginModel implements LoginModel {

    private APILogin apiLogin;

    public SimpleLoginModel() {
        this.apiLogin = APIClient.getClient().create(APILogin.class);
    }

    @Override
    public Single<User> login(String email, String password) {
        return apiLogin.login(new User(email, password));
    }
}

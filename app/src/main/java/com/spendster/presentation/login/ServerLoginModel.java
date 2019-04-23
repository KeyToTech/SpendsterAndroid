package com.spendster.presentation.login;

import com.spendster.data.entity.User;
import com.spendster.presentation.APIClient;

import io.reactivex.Single;

public class ServerLoginModel implements LoginModel {
    @Override
    public Single<User> getUser(String email, String password) {
        APILogin apiLogin = APIClient.getClient().create(APILogin.class);
        return apiLogin.login(new User(email, password));
    }
}

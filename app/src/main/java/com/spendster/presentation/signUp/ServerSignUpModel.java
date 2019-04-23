package com.spendster.presentation.signUp;

import com.spendster.data.entity.User;

import io.reactivex.Single;

public class ServerSignUpModel implements SignUpModel {

    @Override
    public Single<User> getUser(String email, String password) {
        API api = APIClient.getClient().create(API.class);
        return api.signUp(email, password);
    }
}

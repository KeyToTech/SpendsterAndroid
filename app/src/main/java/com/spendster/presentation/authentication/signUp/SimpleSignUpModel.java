package com.spendster.presentation.authentication.signUp;

import com.spendster.data.entity.User;

import io.reactivex.Single;

public class SimpleSignUpModel implements SignUpModel {

    private APISignUp apiSignUp;

    public SimpleSignUpModel(APISignUp apiSignUp) {
        this.apiSignUp = apiSignUp;
    }

    @Override
    public Single<User> signUp(String email, String username, String password) {
        return apiSignUp.signUp(new User(email, username, password));
    }
}

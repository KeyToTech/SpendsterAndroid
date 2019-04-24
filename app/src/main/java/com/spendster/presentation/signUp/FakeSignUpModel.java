package com.spendster.presentation.signUp;

import com.spendster.data.entity.User;

import io.reactivex.Single;

public class FakeSignUpModel implements SignUpModel {
    @Override
    public Single<User> signUp(String email, String userName, String password) {
        return null;
    }
}

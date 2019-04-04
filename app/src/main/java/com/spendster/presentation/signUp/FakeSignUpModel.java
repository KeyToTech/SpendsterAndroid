package com.spendster.presentation.signUp;

import com.spendster.data.entity.User;

import io.reactivex.Single;

public class FakeSignUpModel implements SignUpModel {
    @Override
    public Single<User> getUser(String email, String password) {
        return Single.just(new User(1234, "Ihor"));
    }
}

package com.spendster.presentation.authentication.signUp;

import com.spendster.data.entity.User;

import io.reactivex.Single;

public interface SignUpModel {
    Single<User> signUp(String email, String username, String password);
}

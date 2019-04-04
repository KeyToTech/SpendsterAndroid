package com.spendster.presentation.signUp;

import com.spendster.data.entity.User;

import io.reactivex.Single;

public interface SignUpModel {
    Single<User> getUser(String email, String password);
}

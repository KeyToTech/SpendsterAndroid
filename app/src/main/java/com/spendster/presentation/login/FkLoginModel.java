package com.spendster.presentation.login;

import com.spendster.data.entity.User;

import java.util.Date;

public class FkLoginModel implements LoginModel {
    @Override
    public User login(String email) {
        return new User(14354, "Ihor");
    }
}

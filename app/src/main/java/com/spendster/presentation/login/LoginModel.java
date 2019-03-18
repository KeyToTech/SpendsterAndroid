package com.spendster.presentation.login;

import com.spendster.data.entity.User;

public interface LoginModel {
    User login(String email);
}

package com.spendster.presentation.authentication;

import com.spendster.data.entity.User;

public interface SUserStorage {
    void save(User user);
    User read();
    boolean userExist();
    void clear();
}

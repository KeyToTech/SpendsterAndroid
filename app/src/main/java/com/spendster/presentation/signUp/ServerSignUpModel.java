package com.spendster.presentation.signUp;

import com.spendster.data.entity.User;
import com.spendster.presentation.APIClient;

import io.reactivex.Single;

public class ServerSignUpModel implements SignUpModel {
    @Override
    public Single<User> getUser(String email, String username, String password) {
        APISignUp apiSignUp = APIClient.getClient().create(APISignUp.class);
        return apiSignUp.signUp(new User(email, username, password));
    }
}

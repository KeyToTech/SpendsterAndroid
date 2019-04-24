package com.spendster.presentation.signUp;

import com.spendster.data.entity.User;
import com.spendster.presentation.APIClient;

import io.reactivex.Single;

public class SimpleSignUpModel implements SignUpModel {

    private APISignUp apiSignUp;

    public SimpleSignUpModel() {
        this.apiSignUp = APIClient.getClient().create(APISignUp.class);
    }

    @Override
    public Single<User> signUp(String email, String username, String password) {
        return apiSignUp.signUp(new User(email, username, password));
    }
}

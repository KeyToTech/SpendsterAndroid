package com.spendster.presentation.authentication.signUp;

import com.spendster.data.entity.User;

import io.reactivex.Single;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface APISignUp {
    @Headers({"Content-Type: application/json"})
    @POST("signup")
    Single<User> signUp(@Body User user);
}

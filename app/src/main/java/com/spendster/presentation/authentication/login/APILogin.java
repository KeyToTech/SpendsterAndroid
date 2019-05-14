package com.spendster.presentation.authentication.login;

import com.spendster.data.entity.User;

import io.reactivex.Single;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface APILogin {
    @Headers({"Content-Type: application/json"})
    @POST("login")
    Single<User> login(@Body User user);
}

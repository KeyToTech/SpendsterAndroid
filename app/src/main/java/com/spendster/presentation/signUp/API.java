package com.spendster.presentation.signUp;

import com.spendster.data.entity.User;

import io.reactivex.Single;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface API {
    @Headers({"Content-Type: application/json"})
    @POST("login")
    Single<User> signUp(@Body User user);
}

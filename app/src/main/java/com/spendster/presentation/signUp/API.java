package com.spendster.presentation.signUp;

import com.spendster.data.entity.User;

import io.reactivex.Single;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface API {
    @Headers({"Content-Type: application/json"})
    @FormUrlEncoded
    @POST("login")
    Single<User> signUp(@Field("username") String username, @Field("password") String password);
}

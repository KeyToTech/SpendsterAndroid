package com.spendster.presentation.authentication;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.spendster.data.entity.User;

public class SharedPreferencesUserStorage implements SUserStorage {

    private SharedPreferences sharedPreferences;

    public SharedPreferencesUserStorage(Context context) {
        this.sharedPreferences = context.getSharedPreferences("user_exist", Context.MODE_PRIVATE);
    }

    @Override
    public void save(User user) {
        Gson gson = new Gson();
        String json = gson.toJson(user);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("user_saved", json);
        editor.apply();
    }

    @Override
    public User read() {
        Gson gson = new Gson();
        String json = sharedPreferences.getString("user_saved", "");
        User user = null;
        if (!json.isEmpty()){
            user = gson.fromJson(json, User.class);
        }
        return user;
    }

    @Override
    public boolean UserExist() {
        return this.read() != null;
    }

    @Override
    public void clear() {
        sharedPreferences.edit().clear().apply();
    }
}

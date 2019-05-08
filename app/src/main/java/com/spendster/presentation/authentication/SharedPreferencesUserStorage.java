package com.spendster.presentation.authentication;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.google.gson.Gson;
import com.spendster.data.entity.User;

import java.util.NoSuchElementException;

public class SharedPreferencesUserStorage implements SUserStorage {

    private static final String USER_EXIST = "user_exist";
    private static final String USER_SAVED = "user_saved";

    private SharedPreferences sharedPreferences;

    public SharedPreferencesUserStorage(Context context) {
        this.sharedPreferences = context.getSharedPreferences(USER_EXIST, Context.MODE_PRIVATE);
    }

    @Override
    public void save(User user) {
        Gson gson = new Gson();
        String json = gson.toJson(user);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(USER_SAVED, json);
        editor.apply();
    }

    @Override
    public User read() {
        Gson gson = new Gson();
        String json = sharedPreferences.getString(USER_EXIST, "");
        User user = new User();
        if (!json.isEmpty()) {
            user = gson.fromJson(json, User.class);
        } else {
            throw new NoSuchElementException("User is not found");
        }
        return user;
    }

    @Override
    public boolean userExist() {
        boolean exist = false;
        try {
            exist = read() != null;
        } catch (NoSuchElementException e) {
            Log.d("Error", e.getMessage());
        }
        return exist;
    }

    @Override
    public void clear() {
        sharedPreferences.edit().clear().apply();
    }
}

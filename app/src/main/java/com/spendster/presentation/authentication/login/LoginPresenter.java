package com.spendster.presentation.authentication.login;

import android.content.Context;
import android.content.SharedPreferences;

import com.spendster.data.entity.User;
import com.spendster.presentation.authentication.AuthView;
import com.spendster.presentation.validation.ComplexEmailValidator;
import com.spendster.presentation.validation.ComplexPasswordValidation;
import com.spendster.presentation.validation.ValidationResource;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;



public class LoginPresenter {
    private final Context context;
    private final AuthView loginView;
    private final LoginModel loginModel;
    private final CompositeDisposable compositeDisposable = new CompositeDisposable();


    public LoginPresenter(Context context, AuthView loginView, LoginModel loginModel) {
        this.context = context;
        this.loginView = loginView;
        this.loginModel = loginModel;
    }

    public void login(String email, String password) {
        ValidationResource emailValidation = new ComplexEmailValidator(email).validate();
        ValidationResource passwordValidation = new ComplexPasswordValidation(password).validate();
        if (!emailValidation.isValid()) {
            if (loginView != null) {
                loginView.showError(emailValidation.message());
            }
        } else if (!passwordValidation.isValid()) {
            if (loginView != null) {
                loginView.showError(passwordValidation.message());
            }
        } else {
            if (loginModel != null) {
                compositeDisposable.add(loginModel.login(email, password)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribeWith(new DisposableSingleObserver<User>() {
                            @Override
                            public void onSuccess(User user) {
                                if (loginView != null) {
                                    saveAuthUser(context);
                                    loginView.showNextActivity();
                                }
                            }

                            @Override
                            public void onError(Throwable e) {
                                e.printStackTrace();
                            }
                        }));
            }
        }
    }

    private void saveAuthUser(Context context){
        SharedPreferences sharedPreferences = context.getSharedPreferences("user_exist", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean("user_saved", true);
        editor.apply();
    }

    public void dispose(){
        compositeDisposable.dispose();
    }
}

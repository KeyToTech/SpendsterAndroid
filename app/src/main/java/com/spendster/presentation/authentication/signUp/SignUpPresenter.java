package com.spendster.presentation.authentication.signUp;

import com.spendster.data.entity.User;
import com.spendster.presentation.authentication.AuthView;
import com.spendster.presentation.authentication.SharedPreferencesUserStorage;
import com.spendster.presentation.validation.ComplexEmailValidator;
import com.spendster.presentation.validation.ComplexPasswordValidation;
import com.spendster.presentation.validation.ComplexSimpleValidator;
import com.spendster.presentation.validation.ValidationResource;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;

public class SignUpPresenter {

    private final SharedPreferencesUserStorage sharedPreferencesUserStorage;
    private final AuthView signUpView;
    private final SignUpModel signUpModel;
    private final CompositeDisposable compositeDisposable = new CompositeDisposable();

    public SignUpPresenter(SharedPreferencesUserStorage sharedPreferencesUserStorage, AuthView signUpView, SignUpModel signUpModel) {
        this.sharedPreferencesUserStorage = sharedPreferencesUserStorage;
        this.signUpView = signUpView;
        this.signUpModel = signUpModel;
    }

    public void signUp(final String email, String password, String retypePassword, String username){
        ValidationResource emailValidation = new ComplexEmailValidator(email).validate();
        ValidationResource passwordValidation = new ComplexPasswordValidation(password).validate();
        ValidationResource usernameValidation = new ComplexSimpleValidator(username).validate();
        if (!emailValidation.isValid()) {
            if (signUpView != null) {
                signUpView.showError(emailValidation.message());
            }
        } else if (!passwordValidation.isValid()) {
            if (signUpView != null) {
                signUpView.showError(passwordValidation.message());
            }
        } else if (!password.equals(retypePassword)){
            if (signUpView != null) {
                signUpView.showError("Password is not equal to retype password");
            }
        } else if(!usernameValidation.isValid()){
            signUpView.showError(usernameValidation.message());
        }
        else {
            if (signUpModel != null){
                compositeDisposable.add(signUpModel.signUp(email, username, password)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribeWith(new DisposableSingleObserver<User>() {
                            @Override
                            public void onSuccess(User user) {
                                if (signUpView != null) {
                                    sharedPreferencesUserStorage.save(user);
                                    signUpView.showNextActivity();
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

    public void dispose(){
        compositeDisposable.dispose();
    }
}

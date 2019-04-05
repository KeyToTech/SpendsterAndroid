package com.spendster.presentation.login;

import com.spendster.data.entity.User;
import com.spendster.presentation.AuthView;
import com.spendster.presentation.validation.ComplexEmailValidator;
import com.spendster.presentation.validation.ComplexPasswordValidation;
import com.spendster.presentation.validation.ValidationResource;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;

public class LoginPresenter {
    private final AuthView loginView;
    private final LoginModel loginModel;
    private final CompositeDisposable compositeDisposable = new CompositeDisposable();


    public LoginPresenter(AuthView loginView, LoginModel loginModel) {
        this.loginView = loginView;
        this.loginModel = loginModel;
    }

    public void login(String email, String password) {
        ValidationResource emailValidation = new ComplexEmailValidator(email).validate();
        ValidationResource passwordValidation = new ComplexPasswordValidation(password).validate();
        if (!emailValidation.isValid()) {
            if (loginView != null) {
                loginView.showEmailError(emailValidation.message());
            }
        } else if (!passwordValidation.isValid()) {
            if (loginView != null) {
                loginView.showPasswordError(passwordValidation.message());
            }
        } else {
            if (loginModel != null) {
                compositeDisposable.add(loginModel.getUser(email, password)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribeWith(new DisposableSingleObserver<User>() {
                            @Override
                            public void onSuccess(User user) {
                                if (loginView != null) {
                                    loginView.showNextActivity();
                                }
                            }

                            @Override
                            public void onError(Throwable e) {

                            }
                        }));
            }
        }
    }
}

package com.spendster.presentation.signUp;

import com.spendster.data.entity.User;
import com.spendster.presentation.validation.ComplexEmailValidator;
import com.spendster.presentation.validation.ComplexPasswordValidation;
import com.spendster.presentation.validation.ValidationResource;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;

public class SignUpPresenter {
    private final SignUpView signUpView;
    private final SignUpModel signUpModel;
    private final CompositeDisposable compositeDisposable = new CompositeDisposable();

    public SignUpPresenter(SignUpView signUpView, SignUpModel signUpModel) {
        this.signUpView = signUpView;
        this.signUpModel = signUpModel;
    }

    public void signUp(final String email, String password, String retypePassword){
        ValidationResource emailValidation = new ComplexEmailValidator(email).validate();
        ValidationResource passwordValidation = new ComplexPasswordValidation(password).validate();
        if (!emailValidation.isValid()) {
            if (signUpView != null) {
                signUpView.showEmailError(emailValidation.message());
            }
        } else if (!passwordValidation.isValid()) {
            if (signUpView != null) {
                signUpView.showPasswordError(passwordValidation.message());
            }
        } else if (!password.equals(retypePassword)){
            if (signUpView != null) {
                signUpView.showRetypePasswordError("Password is not equal to retype password");
            }
        }
        else {
            if (signUpModel != null){
                compositeDisposable.add(signUpModel.getUser(email, password)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribeWith(new DisposableSingleObserver<User>() {
                            @Override
                            public void onSuccess(User user) {
                                if (signUpView != null) {
                                    signUpView.showNextActivity();
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

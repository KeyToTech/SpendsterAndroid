package com.spendster.presentation.login;

import com.spendster.presentation.AuthView;
import com.spendster.presentation.validation.ComplexEmailValidator;
import com.spendster.presentation.validation.ComplexPasswordValidation;
import com.spendster.presentation.validation.ValidationResource;

public class LoginPresenter {
    private final AuthView loginView;
    private final LoginModel loginModel;


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
            if (loginModel != null)
            loginModel.getUser(email, password);
            if (loginView != null) {
                loginView.showNextActivity();
            }
        }
    }
}
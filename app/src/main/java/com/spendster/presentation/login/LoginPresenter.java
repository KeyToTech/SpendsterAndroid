package com.spendster.presentation.login;

public class LoginPresenter {
    private final LoginModel loginModel;
    private final LoginActivity loginActivity;


    public LoginPresenter(LoginModel loginModel, LoginActivity loginActivity) {
        this.loginModel = loginModel;
        this.loginActivity = loginActivity;
    }

    public void checkFunc(String email, String password){
        if (isEmailValid(email) && isPasswordValid(password)){
            loginModel.login(email);
            loginActivity.showNextActivity();
        }else if (!isEmailValid(email)){
            loginActivity.showEmailError();
        }else {
            loginActivity.showPasswordError();
        }
    }

    private boolean isPasswordValid(String password) {
        return !password.isEmpty() && password != null;
    }

    private boolean isEmailValid(String email) {
        return email != null && !email.isEmpty();
    }


}

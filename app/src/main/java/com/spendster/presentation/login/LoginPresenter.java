package com.spendster.presentation.login;

import com.spendster.presentation.AuthView;

public class LoginPresenter {
    private final AuthView loginView;
    private final LoginModel loginModel;


    public LoginPresenter(AuthView loginView, LoginModel loginModel) {
        this.loginView = loginView;
        this.loginModel = loginModel;
    }

    public void login(String email, String password){
        if (emailIsValid(email) && passwordIsValid(password)){
            loginModel.getUser(email, password);
            loginView.showNextActivity();
        }
    }

    private boolean emailIsValid(String email){
        boolean check = true;
        String errorMessage = "";
        if(email.isEmpty()){
            errorMessage = "Email field is empty";
            check = false;
        }
        else if (!email.contains("@")){
            errorMessage = "Email must contain @ symbol";
            check = false;
        }
        if (!check){
            loginView.showEmailError(errorMessage);
        }
        return check;
    }

    private boolean passwordIsValid(String password){
        boolean check = true;
        String errorMessage = "";
        if(password.isEmpty()){
            errorMessage = "Password field is empty";
            check = false;
        }
        if (!check){
            loginView.showPasswordError(errorMessage);
        }
        return check;
    }
}

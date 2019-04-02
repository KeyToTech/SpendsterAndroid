package com.spendster.presentation.signUp;

public class SignUpPresenter {
    private final SignUpView signUpView;


    public SignUpPresenter(SignUpView signUpView) {
        this.signUpView = signUpView;
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
            signUpView.showEmailError(errorMessage);
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
            signUpView.showPasswordError(errorMessage);
        }
        return check;
    }

    private boolean retypePasswordIsValid(String password, String retypePassword) {
        boolean check = true;
        String errorMessage = "";
        if (retypePassword.isEmpty()) {
            errorMessage = "Retype password field is empty";
            check = false;
        } else if (!password.equals(retypePassword)) {
            errorMessage = "Password and retype password is not equal";
            check = false;
        }
        if (!check) {
            signUpView.showRetypePasswordError(errorMessage);
        }
        return check;
    }

    public void signUp(String email, String password, String retypePassword){
        if (emailIsValid(email) && passwordIsValid(password) && retypePasswordIsValid(password ,retypePassword)) {
            signUpView.showNextActivity();
        }
    }
}

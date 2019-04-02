package com.spendster.presentation.signUp;

public class SignUpPresenter {
    private final SignUpView signUpView;

    public SignUpPresenter(SignUpView signUpView) {
        this.signUpView = signUpView;
    }

    private boolean emailIsValid(String email){
        boolean check = true;
        if(email.isEmpty()){
            signUpView.showEmailError("Email field is empty");
            check = false;
        }
        else if (!email.contains("@")){
            signUpView.showEmailError("Email must contain @ symbol");
            check = false;
        }
        return check;
    }

    private boolean passwordIsValid(String password){
        boolean check = true;
        if(password.isEmpty()){
            signUpView.showPasswordError("Password field is empty");
            check = false;
        }
        return check;
    }

    private boolean retypePasswordIsValid(String password ,String retypePassword) {
        boolean check = true;
        if(retypePassword.isEmpty()){
            signUpView.showRetypePasswordError("Retype password field is empty");
            check = false;
        }
        else if(!password.equals(retypePassword)){
            signUpView.showRetypePasswordError("Password and retype password is not equal");
            check = false;
        }
        return check;
    }

    public void signUp(String email, String password, String retypePassword){
        if (emailIsValid(email) && passwordIsValid(password) && retypePasswordIsValid(password ,retypePassword)) {
            signUpView.showNextActivity();
        }
    }
}

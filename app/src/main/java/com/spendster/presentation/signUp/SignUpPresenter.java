package com.spendster.presentation.signUp;

public class SignUpPresenter {
    private final SignUpLoginView signUpLoginView;

    public SignUpPresenter(SignUpLoginView signUpLoginView) {
        this.signUpLoginView = signUpLoginView;
    }

    private boolean emailIsValid(String email){
        boolean check = true;
        if(email.isEmpty()){
            signUpLoginView.showEmailIsEmptyError();
            check = false;
        }
        else if (!email.contains("@")){
            signUpLoginView.showEmailAtError();
            check = false;
        }
        return check;
    }

    private boolean passwordISValid(String password, String retypePassword){
        boolean check = true;
        if(password.isEmpty() || retypePassword.isEmpty()){
            signUpLoginView.showPasswordIsEmptyError();
            check = false;
        }
        else if (!password.equals(retypePassword)){
            signUpLoginView.showPasswordNotEqualError();
            check = false;
        }
        return check;
    }

    public void validation(String email, String password, String retypePassword){
        if (emailIsValid(email) && passwordISValid(password, retypePassword))
            signUpLoginView.showNextActivity();
    }
}

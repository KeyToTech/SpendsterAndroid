package com.spendster.presentation.signUp;

public class SignUpPresenter {
    private final SignUpView signUpView;

    public SignUpPresenter(SignUpView signUpView) {
        this.signUpView = signUpView;
    }

    private boolean emailIsValid(String email){
        boolean check = true;
        if(email.isEmpty()){
            signUpView.showEmailIsEmptyError();
            check = false;
        }
        else if (!email.contains("@")){
            signUpView.showEmailAtError();
            check = false;
        }
        return check;
    }

    private boolean passwordIsValid(String password, String retypePassword){
        boolean check = true;
        if(password.isEmpty() || retypePassword.isEmpty()){
            signUpView.showPasswordIsEmptyError();
            check = false;
        }
        else if (!password.equals(retypePassword)){
            signUpView.showPasswordNotEqualError();
            check = false;
        }
        return check;
    }

    public void signUp(String email, String password, String retypePassword){
        if (emailIsValid(email) && passwordIsValid(password, retypePassword)) {
            signUpView.showNextActivity();
        }
    }
}

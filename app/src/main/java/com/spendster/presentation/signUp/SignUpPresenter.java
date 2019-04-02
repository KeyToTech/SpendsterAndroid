package com.spendster.presentation.signUp;

import com.spendster.presentation.validation.ComplexEmailValidator;
import com.spendster.presentation.validation.ComplexPasswordValidation;
import com.spendster.presentation.validation.ValidationResource;

public class SignUpPresenter {
    private final SignUpView signUpView;

    public SignUpPresenter(SignUpView signUpView) {
        this.signUpView = signUpView;
    }

    public void signUp(String email, String password, String retypePassword){
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
            if (signUpView != null) {
                signUpView.showNextActivity();
            }
        }
    }
}

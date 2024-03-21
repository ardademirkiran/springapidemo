package com.agora.springapi.response;

import com.agora.springapi.result.SignupResult;

public class SignupResponse {

    private SignupResult signupResult;

    public SignupResponse(SignupResult signupResult){
        setSignupResult(signupResult);
    }
    public SignupResult getSignupResult() {
        return signupResult;
    }

    public void setSignupResult(SignupResult signupResult) {
        this.signupResult = signupResult;
    }

}

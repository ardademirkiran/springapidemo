package com.agora.springapi.response;

import com.agora.springapi.result.Result;

public class SignupResponse {

    private Result signupResult;

    public SignupResponse(Result signupResult){
        setSignupResult(signupResult);
    }
    public Result getSignupResult() {
        return signupResult;
    }

    public void setSignupResult(Result signupResult) {
        this.signupResult = signupResult;
    }

}

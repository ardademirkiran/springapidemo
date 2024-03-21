package com.agora.springapi.response;

import com.agora.springapi.result.Result;

public class LoginResponse {

    public LoginResponse(Result loginResult){
        this.loginResult = loginResult;
    }

    private Result loginResult;

    public Result getLoginResult() {
        return loginResult;
    }

    public void setLoginResult(Result loginResult) {
        this.loginResult = loginResult;
    }



}

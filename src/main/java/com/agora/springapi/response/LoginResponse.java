package com.agora.springapi.response;

import com.agora.springapi.result.LoginResult;

public class LoginResponse {

    public LoginResponse(LoginResult loginResult){
        this.loginResult = loginResult;
    }

    private LoginResult loginResult;

    public LoginResult getLoginResult() {
        return loginResult;
    }

    public void setLoginResult(LoginResult loginResult) {
        this.loginResult = loginResult;
    }



}

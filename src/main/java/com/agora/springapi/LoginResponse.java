package com.agora.springapi;

public class LoginResponse {

    public LoginResult getLoginResult() {
        return loginResult;
    }

    public void setLoginResult(LoginResult loginResult) {
        this.loginResult = loginResult;
    }

    private LoginResult loginResult;

    public LoginResponse(LoginResult loginResult){
        this.loginResult = loginResult;
    }

}

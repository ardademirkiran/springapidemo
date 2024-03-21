package com.agora.springapi.result;

public class LoginResult {
    private String resultCode;
    private String resultMessage;

    public LoginResult(String i, String resultMessage) {
        setResultCode(i);
        setResultMessage(resultMessage);
    }

    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    public String getResultMessage() {
        return resultMessage;
    }

    public void setResultMessage(String resultMessage) {
        this.resultMessage = resultMessage;
    }

}

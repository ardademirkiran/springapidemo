package com.agora.springapi;

public class LoginResult {
    private int resultCode;
    private String resultMessage;

    public LoginResult(int i, String resultMessage) {
        setResultCode(i);
        setResultMessage(resultMessage);
    }

    public int getResultCode() {
        return resultCode;
    }

    public void setResultCode(int resultCode) {
        this.resultCode = resultCode;
    }

    public String getResultMessage() {
        return resultMessage;
    }

    public void setResultMessage(String resultMessage) {
        this.resultMessage = resultMessage;
    }

}

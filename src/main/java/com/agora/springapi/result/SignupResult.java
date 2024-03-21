package com.agora.springapi.result;

public class SignupResult {

    private String resultCode;
    private String resultMessage;

    public SignupResult(String resultCode, String resultMessage){
        setResultCode(resultCode);
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

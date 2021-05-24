package com.globalwavenet.spring_security.model;

public class ResponseMessage {

    private String result;

    public ResponseMessage() {
    }

    public ResponseMessage(String result) {
        this.result = result;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}

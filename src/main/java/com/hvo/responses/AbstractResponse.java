package com.hvo.responses;

import lombok.ToString;

@ToString
public class AbstractResponse implements Response {

    private int responseCode;

    @Override
    public int getResponseCode() {
        return responseCode;
    }

    @Override
    public void setResponseCode(int responseCode) {
        this.responseCode = responseCode;
    }
}

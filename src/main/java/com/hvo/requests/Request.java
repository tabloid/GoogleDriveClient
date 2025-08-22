package com.hvo.requests;

import org.apache.http.client.methods.HttpRequestBase;

import java.io.UnsupportedEncodingException;

public interface Request {

    HttpRequestBase getRequest() throws UnsupportedEncodingException;

}

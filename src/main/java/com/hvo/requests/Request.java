package com.hvo.requests;

import org.apache.http.client.methods.HttpRequestBase;

public interface Request {

    HttpRequestBase getRequest();

}

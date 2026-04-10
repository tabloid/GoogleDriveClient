package com.hvo.requests.token;

import com.hvo.requests.API;
import com.hvo.requests.AbstractRequest;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;

import java.io.UnsupportedEncodingException;

public class CreateTokenRequest extends AbstractRequest {

    private final String data;

    public CreateTokenRequest(String signedJwtString) {

        this.data = new StringBuilder()
                .append("grant_type=urn%3Aietf%3Aparams%3Aoauth%3Agrant-type%3Ajwt-bearer&")
                .append("assertion=" + signedJwtString)
                .toString();
        logCurl();
    }

    @Override
    public HttpPost getRequest() {
        HttpPost httpPost = new HttpPost(API.TOKEN);
        httpPost.addHeader("Accept", "application/json");
        httpPost.addHeader("Content-type", "application/x-www-form-urlencoded");
        try {
            StringEntity stringEntity = new StringEntity(data);
            httpPost.setEntity(stringEntity);
        } catch (UnsupportedEncodingException ex) {
            logger.error(ex);
        }
        return httpPost;
    }

}

package com.hvo.lib.file.get;

import com.hvo.lib.constants.API;
import com.hvo.lib.core.AbstractRequest;
import org.apache.http.client.methods.HttpGet;

class GetFileRequest extends AbstractRequest {

    private final String url;
    private final String accessToken;

    GetFileRequest(String accessToken, String fileId) {
        this.accessToken = accessToken;
        this.url = new StringBuilder()
                .append(API.FILES)
                .append("/")
                .append(fileId)
                .append("?fields=*")
                .toString();
        logCurl();
    }

    @Override
    public HttpGet getRequest() {
        HttpGet httpGet = new HttpGet(url);
        httpGet.addHeader("Accept", "application/json");
        httpGet.addHeader("Authorization", "Bearer " + accessToken);
        return httpGet;
    }

}

package com.hvo.requests.directory;

import com.hvo.requests.API;
import com.hvo.requests.AbstractRequest;
import org.apache.http.client.methods.HttpGet;

public class GetDirectoryRequest extends AbstractRequest {

    private final String url;
    private final String accessToken;

    public GetDirectoryRequest(String accessToken, String directoryId) {
        this.accessToken = accessToken;
        this.url = new StringBuilder()
                .append(API.FILES)
                .append("/")
                .append(directoryId)
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

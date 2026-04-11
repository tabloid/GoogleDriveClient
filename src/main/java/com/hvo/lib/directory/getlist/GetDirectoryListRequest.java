package com.hvo.lib.directory.getlist;

import com.hvo.lib.constants.API;
import com.hvo.lib.AbstractRequest;
import org.apache.http.client.methods.HttpGet;

class GetDirectoryListRequest extends AbstractRequest {

    private final String url;
    private final String accessToken;

    GetDirectoryListRequest(String accessToken) {
        this.accessToken = accessToken;
        this.url = new StringBuilder()
                .append(API.FILES)
                .append("?q=mimeType%20%3D%20%27application%2Fvnd.google-apps.folder%27")
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

package com.hvo.requests.directory;

import com.hvo.requests.API;
import com.hvo.requests.AbstractRequest;
import com.hvo.requests.util.CurlUtil;
import org.apache.http.client.methods.HttpGet;

public class GetDirectoryListRequest extends AbstractRequest {

    private final String url;
    private final String accessToken;

    public GetDirectoryListRequest(String accessToken) {
        this.accessToken = accessToken;
        this.url = new StringBuilder()
                .append(API.FILES)
                .append("?q=mimeType%20%3D%20%27application%2Fvnd.google-apps.folder%27")
                .toString();
        logCurl();
    }

    @Override
    protected String getCurl() {
        return CurlUtil.convertToCurlString(getRequest());
    }

    @Override
    public HttpGet getRequest() {
        HttpGet httpGet = new HttpGet(url);
        httpGet.setHeader("Accept", "application/json");
        httpGet.setHeader("Authorization", "Bearer " + accessToken);
        return httpGet;
    }

}

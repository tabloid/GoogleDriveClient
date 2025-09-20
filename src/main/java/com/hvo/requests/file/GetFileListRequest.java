package com.hvo.requests.file;

import com.hvo.requests.API;
import com.hvo.requests.AbstractRequest;
import com.hvo.requests.util.CurlUtil;
import org.apache.http.client.methods.HttpGet;

public class GetFileListRequest extends AbstractRequest {

    private final String url;
    private final String accessToken;

    public GetFileListRequest(String accessToken) {
        this.accessToken = accessToken;
        this.url = new StringBuilder()
                .append(API.FILES)
                .append("?q=mimeType%20!%3D%20%27application%2Fvnd.google-apps.folder%27")
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
        httpGet.addHeader("Accept", "application/json");
        httpGet.addHeader("Authorization", "Bearer " + accessToken);
        return httpGet;
    }

}

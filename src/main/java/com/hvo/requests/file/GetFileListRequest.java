package com.hvo.requests.file;

import com.hvo.models.RequestMethod;
import com.hvo.requests.API;
import com.hvo.requests.AbstractRequest;
import org.apache.http.client.methods.HttpGet;

public class GetFileListRequest extends AbstractRequest {

    private final String url;
    private final String requestMethod = RequestMethod.GET.toString();
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
        return new StringBuilder()
                .append("curl " + url)
                .append(" --request " + requestMethod)
                .append(" --verbose ")
                .append(" --header 'Authorization: Bearer " + accessToken)
                .append("'")
                .append(" --header 'Accept: application/json'")
                .toString();
    }

    @Override
    public HttpGet getRequest() {
        HttpGet httpGet = new HttpGet(url);
        httpGet.setHeader("Accept", "application/json");
        httpGet.setHeader("Authorization", "Bearer " + accessToken);
        return httpGet;
    }

}

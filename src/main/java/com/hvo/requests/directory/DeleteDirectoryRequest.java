package com.hvo.requests.directory;

import com.hvo.requests.API;
import com.hvo.requests.AbstractRequest;
import com.hvo.requests.util.CurlUtil;
import org.apache.http.client.methods.HttpDelete;

public class DeleteDirectoryRequest extends AbstractRequest {

    private final String url;
    private final String accessToken;

    public DeleteDirectoryRequest(String accessToken, String directoryId) {
        this.accessToken = accessToken;
        this.url = new StringBuilder()
                .append(API.FILES)
                .append("/")
                .append(directoryId)
                .toString();
        logCurl();
    }

    @Override
    protected String getCurl() {
        return CurlUtil.convertToCurlString(getRequest());
    }

    @Override
    public HttpDelete getRequest() {
        HttpDelete httpDelete = new HttpDelete(url);
        httpDelete.setHeader("Authorization", "Bearer " + accessToken);
        return httpDelete;
    }
}

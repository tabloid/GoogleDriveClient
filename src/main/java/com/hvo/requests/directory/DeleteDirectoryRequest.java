package com.hvo.requests.directory;

import com.hvo.models.RequestMethod;
import com.hvo.requests.API;
import com.hvo.requests.AbstractRequest;
import org.apache.http.client.methods.HttpDelete;

public class DeleteDirectoryRequest extends AbstractRequest {

    private final String url;
    private final String requestMethod = RequestMethod.DELETE.toString();
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
        return new StringBuilder()
                .append("curl " + url)
                .append(" --request " + requestMethod)
                .append(" --verbose ")
                .append(" --header 'Authorization: Bearer " + accessToken)
                .append("'")
                .toString();
    }

    @Override
    public HttpDelete getRequest() {
        HttpDelete httpDelete = new HttpDelete(url);
        httpDelete.setHeader("Accept", "application/json");
        httpDelete.setHeader("Authorization", "Bearer " + accessToken);
        return httpDelete;
    }
}

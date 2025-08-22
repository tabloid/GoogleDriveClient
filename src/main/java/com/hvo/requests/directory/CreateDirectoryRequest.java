package com.hvo.requests.directory;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.hvo.models.RequestMethod;
import com.hvo.requests.API;
import com.hvo.requests.AbstractRequest;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.entity.StringEntity;

import java.io.UnsupportedEncodingException;

public class CreateDirectoryRequest extends AbstractRequest {

    private final String requestMethod = RequestMethod.POST.toString();
    private final String accessToken;
    private final String data;

    public CreateDirectoryRequest(String accessToken, String directoryName) {
        this.accessToken = accessToken;
        this.data = createData(directoryName);
        logCurl();
    }

    private String createData(String directoryName) {
        JsonObject json = new JsonObject();
        json.addProperty("name", directoryName);
        json.addProperty("mimeType", "application/vnd.google-apps.folder");

        JsonArray jsonArray = new JsonArray();
        jsonArray.add("root");
        json.add("parent", jsonArray);

        String jsonString = json.toString();
        return jsonString;
    }

    @Override
    protected String getCurl() {
        return new StringBuilder()
                .append("curl " + API.FILES)
                .append(" --request " + requestMethod)
                .append(" --verbose ")
                .append(" --header 'Authorization: Bearer " + accessToken).append("'")
                .append(" --header 'Accept: application/json'")
                .append(" --header 'Content-Type: application/json'")
                .append(" --data '" + data).append("'")
                .toString();
    }

    @Override
    public HttpPost getRequest() throws UnsupportedEncodingException {
        HttpPost httpPost = new HttpPost(API.FILES);
        httpPost.setEntity(new StringEntity(data));
        httpPost.setHeader("Authorization", "Bearer " + accessToken);
        httpPost.setHeader("Accept", "application/json");
        httpPost.setHeader("Content-type", "application/json");
        return httpPost;
    }
}

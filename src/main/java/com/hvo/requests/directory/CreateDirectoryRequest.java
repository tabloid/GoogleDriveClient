package com.hvo.requests.directory;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.hvo.requests.API;
import com.hvo.requests.AbstractRequest;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;

import java.io.UnsupportedEncodingException;

public class CreateDirectoryRequest extends AbstractRequest {

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
    public HttpPost getRequest() {
        HttpPost httpPost = new HttpPost(API.FILES);
        httpPost.addHeader("Accept", "application/json");
        httpPost.addHeader("Authorization", "Bearer " + accessToken);
        httpPost.addHeader("Content-type", "application/json");
        try {
            StringEntity stringEntity = new StringEntity(data);
            httpPost.setEntity(stringEntity);
        } catch (UnsupportedEncodingException ex) {
            logger.error(ex);
        }
        return httpPost;
    }
}

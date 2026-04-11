package com.hvo.lib.file.create;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.hvo.lib.constants.API;
import com.hvo.lib.core.AbstractRequest;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;

import java.io.UnsupportedEncodingException;

class CreateFileRequest extends AbstractRequest {

    private final String accessToken;
    private final String url;
    private final String data;

    CreateFileRequest(String accessToken, String fileName) {
        this.accessToken = accessToken;
        this.url = new StringBuilder()
                .append(API.FILES)
                .append("?uploadType=resumable")
                .toString();
        this.data = createData(fileName);
        logCurl();
    }

    private String createData(String fileName) {
        JsonObject json = new JsonObject();
        json.addProperty("name", fileName);

        //TODO temporary root dir
        JsonArray jsonArray = new JsonArray();
        jsonArray.add("root");
        json.add("parent", jsonArray);

        String jsonString = json.toString();
        return jsonString;
    }

    @Override
    public HttpPost getRequest() {
        HttpPost httpPost = new HttpPost(url);
        httpPost.addHeader("Accept", "application/json");
        httpPost.addHeader("Authorization", "Bearer " + accessToken);
        httpPost.addHeader("Content-type", "application/json");
        httpPost.addHeader("X-Upload-Content-Type", "application/octet-stream");
        try {
            StringEntity stringEntity = new StringEntity(data);
            httpPost.setEntity(stringEntity);
        } catch (UnsupportedEncodingException ex) {
            logger.error(ex);
        }
        return httpPost;
    }
}

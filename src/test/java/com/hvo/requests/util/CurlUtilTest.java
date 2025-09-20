package com.hvo.requests.util;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.junit.Assert;
import org.junit.Test;

import java.io.UnsupportedEncodingException;

import static com.hvo.requests.util.CurlUtil.convertToCurlString;

public class CurlUtilTest {

    private static final String accessToken = "accessToken";

    @Test
    public void convertGetToCurlString() {
        String url = "https://www.googleapis.com/drive/v3/files/someDirectoryId?fields=*";
        HttpGet httpGet = new HttpGet(url);
        httpGet.addHeader("Accept", "application/json");
        httpGet.addHeader("Authorization", "Bearer " + accessToken);

        String curlString = convertToCurlString(httpGet);
        String expectedCurl = "curl https://www.googleapis.com/drive/v3/files/someDirectoryId?fields=* --request GET --verbose  --header 'Accept: application/json' --header 'Authorization: Bearer accessToken'";
        Assert.assertEquals(expectedCurl, curlString);
    }

    @Test
    public void convertPostToCurlString() throws UnsupportedEncodingException {
        String url = "https://www.googleapis.com/drive/v3/files";
        HttpPost httpPost = new HttpPost(url);
        httpPost.addHeader("Accept", "application/json");
        httpPost.addHeader("Authorization", "Bearer " + accessToken);
        httpPost.addHeader("Content-type", "application/json");
        String data = createData("someDirectoryName");
        StringEntity stringEntity = new StringEntity(data);
        httpPost.setEntity(stringEntity);

        String curlString = convertToCurlString(httpPost);
        String expectedCurl = "curl https://www.googleapis.com/drive/v3/files --request POST --verbose  --header 'Accept: application/json' --header 'Authorization: Bearer accessToken' --header 'Content-type: application/json' --data '{\"name\":\"someDirectoryName\",\"mimeType\":\"application/vnd.google-apps.folder\",\"parent\":[\"root\"]}'";
        Assert.assertEquals(expectedCurl, curlString);


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

}

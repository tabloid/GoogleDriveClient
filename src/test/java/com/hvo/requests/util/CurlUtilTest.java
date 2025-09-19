package com.hvo.requests.util;

import org.apache.http.client.methods.HttpGet;
import org.junit.Assert;
import org.junit.Test;

import static com.hvo.requests.util.CurlUtil.convertToCurlString;

public class CurlUtilTest {

    @Test
    public void convertGetToCurlString() {
        String url = "https://www.googleapis.com/drive/v3/files/someDirectoryId?fields=*";
        HttpGet httpGet = new HttpGet(url);
        httpGet.addHeader("Accept", "application/json");
        httpGet.addHeader("Authorization", "Bearer " + "accessToken");
        String curlString = convertToCurlString(httpGet);
        String expectedCurl = "curl https://www.googleapis.com/drive/v3/files/someDirectoryId?fields=* --request GET --verbose  --header 'Accept: application/json' --header 'Authorization: Bearer accessToken'";
        Assert.assertEquals(expectedCurl, curlString);
    }
}

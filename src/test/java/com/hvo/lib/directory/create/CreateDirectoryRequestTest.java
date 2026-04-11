package com.hvo.lib.directory.create;


import org.junit.Assert;
import org.junit.Test;

public class CreateDirectoryRequestTest {

    private static final String accessToken = "someToken";
    private static final String directoryName = "someDirectoryName";

    @Test
    public void createDirectoryRequestTest() {
        CreateDirectoryRequest request = new CreateDirectoryRequest(accessToken, directoryName);
        String curl = request.getCurl();
        String expectedCurl = "curl https://www.googleapis.com/drive/v3/files --request POST --verbose  --header 'Accept: application/json' --header 'Authorization: Bearer someToken' --header 'Content-type: application/json' --data '{\"name\":\"someDirectoryName\",\"mimeType\":\"application/vnd.google-apps.folder\",\"parent\":[\"root\"]}'";
        Assert.assertEquals(expectedCurl, curl);
    }

}

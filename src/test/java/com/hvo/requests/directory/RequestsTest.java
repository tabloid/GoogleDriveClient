package com.hvo.requests.directory;


import org.junit.Assert;
import org.junit.Test;

public class RequestsTest {

    private static final String accessToken = "someToken";

    @Test
    public void createDirectoryRequestTest() {
        String directoryName = "someDirectoryName";
        CreateDirectoryRequest request = new CreateDirectoryRequest(accessToken, directoryName);
        String curl = request.getCurl();
        String expectedCurl = "curl https://www.googleapis.com/drive/v3/files --request POST --verbose  --header 'Authorization: Bearer someToken' --header 'Accept: application/json' --header 'Content-Type: application/json' --data '{\"name\":\"someDirectoryName\",\"mimeType\":\"application/vnd.google-apps.folder\",\"parent\":[\"root\"]}'";
        Assert.assertEquals(expectedCurl, curl);
    }

    @Test
    public void getDirectoryRequestTest() {
        String directoryId = "someDirectoryId";
        GetDirectoryRequest request = new GetDirectoryRequest(accessToken, directoryId);
        String curl = request.getCurl();
        String expectedCurl = "curl https://www.googleapis.com/drive/v3/files/someDirectoryId?fields=* --request GET --verbose  --header 'Authorization: Bearer someToken' --header 'Accept: application/json'";
        Assert.assertEquals(expectedCurl, curl);
    }

    @Test
    public void getDirectoryListRequestTest() {
        GetDirectoryListRequest request = new GetDirectoryListRequest(accessToken);
        String curl = request.getCurl();
        String expectedCurl = "curl https://www.googleapis.com/drive/v3/files?q=mimeType%20%3D%20%27application%2Fvnd.google-apps.folder%27 --request GET --verbose  --header 'Authorization: Bearer someToken' --header 'Accept: application/json'";
        Assert.assertEquals(expectedCurl, curl);
    }

}

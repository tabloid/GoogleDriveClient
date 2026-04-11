package com.hvo.lib.directory.get;


import org.junit.Assert;
import org.junit.Test;

public class GetDirectoryRequestTest {

    private static final String accessToken = "someToken";
    private static final String directoryId = "someDirectoryId";

    @Test
    public void getDirectoryRequestTest() {
        GetDirectoryRequest request = new GetDirectoryRequest(accessToken, directoryId);
        String curl = request.getCurl();
        String expectedCurl = "curl https://www.googleapis.com/drive/v3/files/someDirectoryId?fields=* --request GET --verbose  --header 'Accept: application/json' --header 'Authorization: Bearer someToken'";
        Assert.assertEquals(expectedCurl, curl);
    }

}

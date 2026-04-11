package com.hvo.lib.directory.getlist;


import org.junit.Assert;
import org.junit.Test;

public class GetDirectoryListRequestTest {

    private static final String accessToken = "someToken";

    @Test
    public void getDirectoryListRequestTest() {
        GetDirectoryListRequest request = new GetDirectoryListRequest(accessToken);
        String curl = request.getCurl();
        String expectedCurl = "curl https://www.googleapis.com/drive/v3/files?q=mimeType%20%3D%20%27application%2Fvnd.google-apps.folder%27 --request GET --verbose  --header 'Accept: application/json' --header 'Authorization: Bearer someToken'";
        Assert.assertEquals(expectedCurl, curl);
    }

}

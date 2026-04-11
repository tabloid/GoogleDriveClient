package com.hvo.lib.file.get;

import org.junit.Assert;
import org.junit.Test;

public class GetFileRequestTest {

    private static final String accessToken = "someToken";
    private static final String fileId = "someFileId";

    @Test
    public void getFileRequestTest() {
        GetFileRequest request = new GetFileRequest(accessToken, fileId);
        String curl = request.getCurl();
        String expectedCurl = "curl https://www.googleapis.com/drive/v3/files/someFileId?fields=* --request GET --verbose  --header 'Accept: application/json' --header 'Authorization: Bearer someToken'";
        Assert.assertEquals(expectedCurl, curl);
    }
}

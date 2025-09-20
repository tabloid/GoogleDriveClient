package com.hvo.requests.file;

import org.junit.Assert;
import org.junit.Test;

public class FileRequestsTest {

    private static final String accessToken = "someToken";
    private static final String fileName = "someFileName";
    private static final String fileId = "someFileId";

    @Test
    public void getFileListRequestTest() {
        GetFileListRequest request = new GetFileListRequest(accessToken);
        String curl = request.getCurl();
        String expectedCurl = "curl https://www.googleapis.com/drive/v3/files?q=mimeType%20!%3D%20%27application%2Fvnd.google-apps.folder%27 --request GET --verbose  --header 'Accept: application/json' --header 'Authorization: Bearer someToken'";
        Assert.assertEquals(expectedCurl, curl);
    }
}

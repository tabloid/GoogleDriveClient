package com.hvo.lib.directory.delete;


import org.junit.Assert;
import org.junit.Test;

public class DeleteDirectoryRequestTest {

    private static final String accessToken = "someToken";
    private static final String directoryId = "someDirectoryId";

    @Test
    public void deleteDirectoryRequestTest() {
        DeleteDirectoryRequest request = new DeleteDirectoryRequest(accessToken, directoryId);
        String curl = request.getCurl();
        String expectedCurl = "curl https://www.googleapis.com/drive/v3/files/someDirectoryId --request DELETE --verbose  --header 'Authorization: Bearer someToken'";
        Assert.assertEquals(expectedCurl, curl);
    }

}

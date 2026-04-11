package com.hvo.lib.token.create;

import org.junit.Assert;
import org.junit.Test;

public class CreateTokenRequestTest {

    @Test
    public void createTokenRequestTest() {
        String mockedSignedJWT = "mockedSignedJWT";
        CreateTokenRequest request = new CreateTokenRequest(mockedSignedJWT);
        String curl = request.getCurl();
        String expectedCurl = "curl https://oauth2.googleapis.com/token --request POST --verbose  --header 'Accept: application/json' --header 'Content-type: application/x-www-form-urlencoded' --data 'grant_type=urn%3Aietf%3Aparams%3Aoauth%3Agrant-type%3Ajwt-bearer&assertion=mockedSignedJWT'";
        Assert.assertEquals(expectedCurl, curl);
    }
}

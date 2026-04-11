package com.hvo.lib.token.create;

import com.google.auth.oauth2.ServiceAccountCredentials;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.math.BigInteger;
import java.net.URI;
import java.net.URISyntaxException;
import java.security.interfaces.RSAPrivateKey;

public class SignedJWTTest {

    @Test
    public void createJWTStringTest() throws URISyntaxException {
        ServiceAccountCredentials serviceAccountCredentials = createServiceAccountCredentials();
        SignedJWT signedJWT = new SignedJWT(serviceAccountCredentials);
        String actualSignedJWTString = signedJWT.createJWTString();

        String[] actualSplitResponse = actualSignedJWTString.split("\\.");
        Assert.assertEquals(3, actualSplitResponse.length);
        String expectedFirstPart = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9";
        Assert.assertEquals(expectedFirstPart, actualSplitResponse[0]);
        String expectedSecondPart = "eyJhdWQiOiJodHRwczovL29hdXRoMi5nb29nbGVhcGlzLmNvbS90b2tlbiIsInNjb3BlIjoiaHR0cHM6Ly93d3cuZ29vZ2xlYXBpcy5jb20vYXV0aC9kcml2ZSBodHRwczovL3d3dy5nb29nbGVhcGlzLmNvbS9hdXRoL2RyaXZlLmFwcGRhdGEgaHR0cHM6Ly";
        Assert.assertTrue(actualSplitResponse[1].startsWith(expectedSecondPart));
        String expectedThirdPart = "AAH_____________ADAxMA0GCWCGSAF";
        Assert.assertTrue(actualSplitResponse[2].startsWith(expectedThirdPart));
    }

    private ServiceAccountCredentials createServiceAccountCredentials() throws URISyntaxException {
        String clientEmail = "some@mail.ua";
        URI tokenServerUri = new URI("https://oauth2.googleapis.com/token");
        RSAPrivateKey privateKey = createPrivateKeyMock();
        ServiceAccountCredentials serviceAccountCredentials = ServiceAccountCredentials.newBuilder()
                .setClientEmail(clientEmail).setTokenServerUri(tokenServerUri).setPrivateKey(privateKey).build();
        return serviceAccountCredentials;
    }

    private RSAPrivateKey createPrivateKeyMock() {
        RSAPrivateKey rsaPrivateKey = Mockito.mock(RSAPrivateKey.class);
        Mockito.doReturn("RSA").when(rsaPrivateKey).getAlgorithm();
        BigInteger modulus = new BigInteger("11111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111");
        Mockito.doReturn(modulus).when(rsaPrivateKey).getModulus();
        Mockito.doReturn(BigInteger.ONE).when(rsaPrivateKey).getPrivateExponent();
        return rsaPrivateKey;
    }

}

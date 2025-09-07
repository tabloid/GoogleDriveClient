package com.hvo.requests.token;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.google.auth.oauth2.ServiceAccountCredentials;
import com.hvo.models.RequestMethod;
import com.hvo.requests.API;
import com.hvo.requests.AbstractRequest;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;

import java.io.UnsupportedEncodingException;
import java.security.PrivateKey;
import java.security.interfaces.RSAPrivateKey;
import java.util.Date;

public class CreateTokenRequest extends AbstractRequest {

    private final String requestMethod = RequestMethod.POST.toString();
    private final String data;

    public CreateTokenRequest(ServiceAccountCredentials serviceAccountCredentials) {
        String signedJwt = createJWT(serviceAccountCredentials);
        this.data = new StringBuilder()
                .append("grant_type=urn%3Aietf%3Aparams%3Aoauth%3Agrant-type%3Ajwt-bearer&")
                .append("assertion=" + signedJwt)
                .toString();
        logCurl();
    }

    @Override
    public HttpPost getRequest() throws UnsupportedEncodingException {
        HttpPost httpPost = new HttpPost(API.TOKEN);
        httpPost.setEntity(new StringEntity(data));
        httpPost.setHeader("Accept", "application/json");
        httpPost.setHeader("Content-type", "application/x-www-form-urlencoded");
        return httpPost;
    }

    @Override
    protected String getCurl() {
        return new StringBuilder()
                .append("curl " + API.TOKEN)
                .append(" --request " + requestMethod)
                .append(" --verbose ")
                .append(" --data '" + data)
                .append("'")
                .toString();
    }

    private String createJWT(ServiceAccountCredentials serviceAccountCredentials) {
        String issuer = serviceAccountCredentials.getClientEmail();
        String audience = serviceAccountCredentials.getTokenServerUri().toString();

        long now = System.currentTimeMillis();
        Date issuedAt = new Date(now);
        Date expiresAt = new Date(now + 3600);

        PrivateKey privateKey = serviceAccountCredentials.getPrivateKey();
        Algorithm algorithm = Algorithm.RSA256(null, (RSAPrivateKey) privateKey);

        String signedJwt = JWT.create()
                .withIssuer(issuer)
                .withClaim("scope", "https://www.googleapis.com/auth/drive https://www.googleapis.com/auth/drive.appdata https://www.googleapis.com/auth/drive.file")
                .withAudience(audience)
                .withExpiresAt(expiresAt)
                .withIssuedAt(issuedAt)
                .sign(algorithm);
        return signedJwt;
    }

}

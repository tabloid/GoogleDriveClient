package com.hvo.requests.token;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.google.auth.oauth2.ServiceAccountCredentials;

import java.security.PrivateKey;
import java.security.interfaces.RSAPrivateKey;
import java.util.Date;

public class SignedJWT {
    private static final long LIVELINESS_DURATION = 3600;
    private final String issuer;
    private final String audience;
    private final PrivateKey privateKey;

    public SignedJWT(ServiceAccountCredentials serviceAccountCredentials) {
        this.issuer = serviceAccountCredentials.getClientEmail();
        this.audience = serviceAccountCredentials.getTokenServerUri().toString();
        this.privateKey = serviceAccountCredentials.getPrivateKey();
    }

    public String createJWTString() {
        long now = System.currentTimeMillis();
        Date issuedAt = new Date(now);
        long then = now + LIVELINESS_DURATION;
        Date expiresAt = new Date(then);

        Algorithm algorithm = Algorithm.RSA256(null, (RSAPrivateKey) privateKey);

        String signedJwtString = JWT.create()
                .withIssuer(issuer)
                .withAudience(audience)
                .withClaim("scope", "https://www.googleapis.com/auth/drive https://www.googleapis.com/auth/drive.appdata https://www.googleapis.com/auth/drive.file")
                .withIssuedAt(issuedAt)
                .withExpiresAt(expiresAt)
                .sign(algorithm);
        return signedJwtString;
    }

}

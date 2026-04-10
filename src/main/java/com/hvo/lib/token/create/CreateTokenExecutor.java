package com.hvo.lib.token.create;

import com.google.auth.oauth2.ServiceAccountCredentials;

public class CreateTokenExecutor {

    private CreateTokenExecutor() {}

    public static CreateTokenResponse createToken(ServiceAccountCredentials serviceAccountCredentials) {
        return new CreateTokenAction(serviceAccountCredentials).execute();
    }
}

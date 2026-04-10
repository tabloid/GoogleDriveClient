package com.hvo.actions.token;

import com.google.auth.oauth2.ServiceAccountCredentials;
import com.hvo.actions.AbstractAction;
import com.hvo.requests.token.CreateTokenRequest;
import com.hvo.requests.token.SignedJWT;
import com.hvo.responses.token.CreateTokenResponse;

public class CreateTokenAction extends AbstractAction<CreateTokenResponse> {

    private final ServiceAccountCredentials serviceAccountCredentials;

    public CreateTokenAction(ServiceAccountCredentials serviceAccountCredentials) {
        this.serviceAccountCredentials = serviceAccountCredentials;
    }

    @Override
    public CreateTokenResponse execute() {
        SignedJWT signedJWT = new SignedJWT(serviceAccountCredentials);
        String signedJWTString = signedJWT.createJWTString();
        CreateTokenRequest createTokenRequest = new CreateTokenRequest(signedJWTString);
        return execute(createTokenRequest, CreateTokenResponse.class);
    }

}

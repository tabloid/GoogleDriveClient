package com.hvo.lib.token.create;

import com.google.auth.oauth2.ServiceAccountCredentials;
import com.hvo.actions.AbstractAction;

class CreateTokenAction extends AbstractAction<CreateTokenResponse> {

    private final ServiceAccountCredentials serviceAccountCredentials;

    CreateTokenAction(ServiceAccountCredentials serviceAccountCredentials) {
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

package com.hvo.actions.token;

import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.hvo.actions.AbstractAction;
import com.hvo.requests.token.CreateTokenRequest;
import com.hvo.responses.token.CreateTokenResponse;

public class CreateTokenAction extends AbstractAction<CreateTokenResponse> {

    private final GoogleCredential credential;

    public CreateTokenAction(GoogleCredential credential) {
        this.credential = credential;
    }

    @Override
    public CreateTokenResponse execute() {
        CreateTokenRequest createTokenRequest = new CreateTokenRequest(credential);
        return execute(createTokenRequest, CreateTokenResponse.class);
    }

}

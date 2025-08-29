package com.hvo.actions.token;

import com.google.auth.oauth2.GoogleCredentials;
import com.hvo.actions.AbstractAction;
import com.hvo.requests.token.CreateTokenRequest;
import com.hvo.responses.token.CreateTokenResponse;

public class CreateTokenAction extends AbstractAction<CreateTokenResponse> {

    private final GoogleCredentials credential;

    public CreateTokenAction(GoogleCredentials credential) {
        this.credential = credential;
    }

    @Override
    public CreateTokenResponse execute() {
        CreateTokenRequest createTokenRequest = new CreateTokenRequest(credential);
        return execute(createTokenRequest, CreateTokenResponse.class);
    }

}

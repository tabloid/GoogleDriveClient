package com.hvo.actions.file;

import com.google.auth.oauth2.ServiceAccountCredentials;
import com.hvo.actions.token.CreateTokenAction;
import com.hvo.responses.file.GetFileListResponse;
import com.hvo.responses.token.CreateTokenResponse;

public class FileActions {

    private final String accessToken;

    public FileActions(ServiceAccountCredentials serviceAccountCredentials) {
        this.accessToken = createToken(serviceAccountCredentials);
    }

    private String createToken(ServiceAccountCredentials serviceAccountCredentials) {
        CreateTokenAction createTokenAction = new CreateTokenAction(serviceAccountCredentials);
        CreateTokenResponse createTokenResponse = createTokenAction.execute();
        String accessToken = createTokenResponse.getAccessToken();
        return accessToken;
    }

    public GetFileListResponse getFileList() {
        return new GetFileListAction(accessToken).execute();
    }


}

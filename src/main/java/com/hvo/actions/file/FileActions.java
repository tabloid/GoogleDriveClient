package com.hvo.actions.file;

import com.google.auth.oauth2.ServiceAccountCredentials;
import com.hvo.lib.token.create.CreateTokenExecutor;
import com.hvo.lib.token.create.CreateTokenResponse;
import com.hvo.responses.file.GetFileListResponse;

public class FileActions {

    private final String accessToken;

    public FileActions(ServiceAccountCredentials serviceAccountCredentials) {
        this.accessToken = createToken(serviceAccountCredentials);
    }

    private String createToken(ServiceAccountCredentials serviceAccountCredentials) {
        CreateTokenResponse createTokenResponse = CreateTokenExecutor.createToken(serviceAccountCredentials);
        String accessToken = createTokenResponse.getAccessToken();
        return accessToken;
    }

    public GetFileListResponse getFileList() {
        return new GetFileListAction(accessToken).execute();
    }


}

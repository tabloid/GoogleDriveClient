package com.hvo.actions.file;

import com.google.auth.oauth2.GoogleCredentials;
import com.hvo.actions.token.CreateTokenAction;
import com.hvo.responses.file.GetFileListResponse;
import com.hvo.responses.token.CreateTokenResponse;

public class FileActions {

    private final String accessToken;

    public FileActions(GoogleCredentials googleCredential) {
        this.accessToken = createToken(googleCredential);
    }

    private String createToken(GoogleCredentials googleCredential) {
        CreateTokenAction createTokenAction = new CreateTokenAction(googleCredential);
        CreateTokenResponse createTokenResponse = createTokenAction.execute();
        String accessToken = createTokenResponse.getAccessToken();
        return accessToken;
    }

    public GetFileListResponse getFileList() {
        return new GetFileListAction(accessToken).execute();
    }


}

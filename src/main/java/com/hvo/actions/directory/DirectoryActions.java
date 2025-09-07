package com.hvo.actions.directory;

import com.google.auth.oauth2.ServiceAccountCredentials;
import com.hvo.actions.token.CreateTokenAction;
import com.hvo.responses.directory.CreateDirectoryResponse;
import com.hvo.responses.directory.DeleteDirectoryResponse;
import com.hvo.responses.directory.GetDirectoryListResponse;
import com.hvo.responses.directory.GetDirectoryResponse;
import com.hvo.responses.token.CreateTokenResponse;

public class DirectoryActions {

    private final String accessToken;

    public DirectoryActions(ServiceAccountCredentials serviceAccountCredentials) {
        this.accessToken = createToken(serviceAccountCredentials);
    }

    private String createToken(ServiceAccountCredentials serviceAccountCredentials) {
        CreateTokenAction createTokenAction = new CreateTokenAction(serviceAccountCredentials);
        CreateTokenResponse createTokenResponse = createTokenAction.execute();
        String accessToken = createTokenResponse.getAccessToken();
        return accessToken;
    }

    public CreateDirectoryResponse createDirectory(String directoryName) {
        return new CreateDirectoryAction(accessToken, directoryName).execute();
    }

    public GetDirectoryResponse getDirectory(String directoryId) {
        return new GetDirectoryAction(accessToken, directoryId).execute();
    }

    public GetDirectoryListResponse getDirectoryList() {
        return new GetDirectoryListAction(accessToken).execute();
    }

    public DeleteDirectoryResponse deleteDirectory(String directoryId) {
        return new DeleteDirectoryAction(accessToken, directoryId).execute();
    }

}

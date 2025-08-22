package com.hvo.actions.directory;

import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.hvo.actions.token.CreateTokenAction;
import com.hvo.responses.directory.CreateDirectoryResponse;
import com.hvo.responses.directory.DeleteDirectoryResponse;
import com.hvo.responses.token.CreateTokenResponse;
import com.hvo.responses.directory.GetDirectoryListResponse;
import com.hvo.responses.directory.GetDirectoryResponse;

public class DirectoryActions {

    private String accessToken;

    public DirectoryActions(GoogleCredential googleCredential) {
        this.accessToken = createToken(googleCredential);
    }

    private String createToken(GoogleCredential googleCredential) {
        CreateTokenAction createTokenAction = new CreateTokenAction(googleCredential);
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

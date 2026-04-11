package com.hvo.lib.api;

import com.google.auth.oauth2.ServiceAccountCredentials;
import com.hvo.lib.directory.create.CreateDirectoryExecutor;
import com.hvo.lib.directory.create.CreateDirectoryResponse;
import com.hvo.lib.directory.delete.DeleteDirectoryExecutor;
import com.hvo.lib.directory.delete.DeleteDirectoryResponse;
import com.hvo.lib.directory.get.GetDirectoryExecutor;
import com.hvo.lib.directory.get.GetDirectoryResponse;
import com.hvo.lib.directory.getlist.GetDirectoryListExecutor;
import com.hvo.lib.directory.getlist.GetDirectoryListResponse;
import com.hvo.lib.token.create.CreateTokenExecutor;
import com.hvo.lib.token.create.CreateTokenResponse;

public class DirectoryActions {

    private final String accessToken;

    DirectoryActions(ServiceAccountCredentials serviceAccountCredentials) {
        this.accessToken = createToken(serviceAccountCredentials);
    }

    private String createToken(ServiceAccountCredentials serviceAccountCredentials) {
        CreateTokenResponse createTokenResponse = CreateTokenExecutor.createToken(serviceAccountCredentials);
        return createTokenResponse.getAccessToken();
    }

    public CreateDirectoryResponse createDirectory(String directoryName) {
        return CreateDirectoryExecutor.createDirectory(accessToken, directoryName);
    }

    public GetDirectoryResponse getDirectory(String directoryId) {
        return GetDirectoryExecutor.getDirectory(accessToken, directoryId);
    }

    public GetDirectoryListResponse getDirectoryList() {
        return GetDirectoryListExecutor.getDirectoryList(accessToken);
    }

    public DeleteDirectoryResponse deleteDirectory(String directoryId) {
        return DeleteDirectoryExecutor.deleteDirectory(accessToken, directoryId);
    }

}

package com.hvo.lib.file;

import com.google.auth.oauth2.ServiceAccountCredentials;
import com.hvo.lib.file.create.CreateFileExecutor;
import com.hvo.lib.file.create.CreateFileResponse;
import com.hvo.lib.file.get.GetFileExecutor;
import com.hvo.lib.file.get.GetFileResponse;
import com.hvo.lib.file.getlist.GetFileListExecutor;
import com.hvo.lib.file.getlist.GetFileListResponse;
import com.hvo.lib.token.create.CreateTokenExecutor;
import com.hvo.lib.token.create.CreateTokenResponse;

public class FileActions {

    private final String accessToken;

    public FileActions(ServiceAccountCredentials serviceAccountCredentials) {
        this.accessToken = createToken(serviceAccountCredentials);
    }

    private String createToken(ServiceAccountCredentials serviceAccountCredentials) {
        CreateTokenResponse createTokenResponse = CreateTokenExecutor.createToken(serviceAccountCredentials);
        return createTokenResponse.getAccessToken();
    }

    public CreateFileResponse createFile(String fileName) {
        return CreateFileExecutor.createFile(accessToken, fileName);
    }

    public GetFileResponse getFile(String fileId) {
        return GetFileExecutor.getFile(accessToken, fileId);
    }

    public GetFileListResponse getFileList() {
        return GetFileListExecutor.getFileList(accessToken);
    }


}

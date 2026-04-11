package com.hvo.lib.file.get;

public class GetFileExecutor {

    private GetFileExecutor() {}

    public static GetFileResponse getFile(String accessToken, String fileId) {
        return new GetFileAction(accessToken, fileId).execute();
    }
}

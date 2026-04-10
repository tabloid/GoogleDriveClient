package com.hvo.lib.file.getlist;

public class GetFileListExecutor {

    private GetFileListExecutor() {}

    public static GetFileListResponse getFileList(String accessToken) {
        return new GetFileListAction(accessToken).execute();
    }
}

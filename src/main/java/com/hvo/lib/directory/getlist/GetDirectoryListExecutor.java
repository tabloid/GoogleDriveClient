package com.hvo.lib.directory.getlist;

public class GetDirectoryListExecutor {

    private GetDirectoryListExecutor() {}

    public static GetDirectoryListResponse getDirectoryList(String accessToken) {
        return new GetDirectoryListAction(accessToken).execute();
    }
}

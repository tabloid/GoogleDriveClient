package com.hvo.lib.directory.get;

public class GetDirectoryExecutor {

    private GetDirectoryExecutor() {}

    public static GetDirectoryResponse getDirectory(String accessToken, String directoryId) {
        return new GetDirectoryAction(accessToken, directoryId).execute();
    }
}

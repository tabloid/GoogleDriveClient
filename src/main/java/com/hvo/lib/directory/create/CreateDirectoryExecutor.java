package com.hvo.lib.directory.create;

public class CreateDirectoryExecutor {

    private CreateDirectoryExecutor() {}

    public static CreateDirectoryResponse createDirectory(String accessToken, String directoryName) {
        return new CreateDirectoryAction(accessToken, directoryName).execute();
    }
}

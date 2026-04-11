package com.hvo.lib.file.create;

public class CreateFileExecutor {

    private CreateFileExecutor() {}

    public static CreateFileResponse createFile(String accessToken, String fileName) {
        return new CreateFileAction(accessToken, fileName).execute();
    }
}

package com.hvo.lib.directory.delete;

public class DeleteDirectoryExecutor {

    private DeleteDirectoryExecutor() {}

    public static DeleteDirectoryResponse deleteDirectory(String accessToken, String directoryId) {
        return new DeleteDirectoryAction(accessToken, directoryId).execute();
    }
}

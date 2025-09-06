package com.hvo;

import com.google.auth.oauth2.GoogleCredentials;
import com.hvo.actions.directory.DirectoryActions;
import com.hvo.actions.file.FileActions;
import com.hvo.responses.directory.CreateDirectoryResponse;
import com.hvo.responses.directory.DeleteDirectoryResponse;
import com.hvo.responses.directory.GetDirectoryListResponse;
import com.hvo.responses.directory.GetDirectoryResponse;
import com.hvo.responses.file.GetFileListResponse;

import java.io.IOException;
import java.io.InputStream;

public class App {

    public static void main(String[] args) throws IOException {
        GoogleCredentials googleCredential = createGoogleCredential();

        System.out.println("START DIRECTORY TESTS");
        DirectoryActions directoryActions = new DirectoryActions(googleCredential);

        GetDirectoryListResponse getDirectoryListResponse = directoryActions.getDirectoryList();
        String directoryId = getDirectoryListResponse.getFiles().get(0).getId();

        GetDirectoryResponse getDirectoryResponse = directoryActions.getDirectory(directoryId);

        String directoryName = "seva_3";
        CreateDirectoryResponse createDirectoryResponse = directoryActions.createDirectory(directoryName);
        directoryId = createDirectoryResponse.getId();

        DeleteDirectoryResponse deleteDirectoryResponse = directoryActions.deleteDirectory(directoryId);
        System.out.println("END DIRECTORY TESTS");

        System.out.println("START FILE TESTS");
        FileActions fileActions = new FileActions(googleCredential);

        GetFileListResponse getFileListResponse = fileActions.getFileList();
        String fileId = getFileListResponse.getFiles().get(0).getId();
        System.out.println("END FILE TESTS");
    }

    private static GoogleCredentials createGoogleCredential() throws IOException {
        String resourceName = "gdrive-storage-297122-e20587d1d42a.json";
        InputStream inputStream = App.class.getClassLoader().getResourceAsStream(resourceName);
        return GoogleCredentials.fromStream(inputStream);
    }

}

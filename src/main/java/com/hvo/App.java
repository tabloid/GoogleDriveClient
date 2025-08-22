package com.hvo;

import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.hvo.actions.directory.DirectoryActions;
import com.hvo.responses.directory.CreateDirectoryResponse;
import com.hvo.responses.directory.DeleteDirectoryResponse;
import com.hvo.responses.directory.GetDirectoryListResponse;
import com.hvo.responses.directory.GetDirectoryResponse;

import java.io.IOException;
import java.io.InputStream;

public class App {

    public static void main(String[] args) throws IOException {
        GoogleCredential googleCredential = createGoogleCredential();
        DirectoryActions directoryActions = new DirectoryActions(googleCredential);

        GetDirectoryListResponse getDirectoryListResponse = directoryActions.getDirectoryList();
        String directoryId = getDirectoryListResponse.getFiles().get(0).getId();

        GetDirectoryResponse getDirectoryResponse = directoryActions.getDirectory(directoryId);

        String directoryName = "seva_3";
        CreateDirectoryResponse createDirectoryResponse = directoryActions.createDirectory(directoryName);
        directoryId = createDirectoryResponse.getId();

        DeleteDirectoryResponse deleteDirectoryResponse = directoryActions.deleteDirectory(directoryId);
        System.out.println();
    }

    private static GoogleCredential createGoogleCredential() throws IOException {
        String resourceName = "gdrive-storage-297122-e20587d1d42a.json";
        InputStream inputStream = App.class.getClassLoader().getResourceAsStream(resourceName);
        return GoogleCredential.fromStream(inputStream);
    }

}

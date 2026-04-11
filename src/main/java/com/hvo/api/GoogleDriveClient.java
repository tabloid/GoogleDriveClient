package com.hvo.api;

import com.google.auth.oauth2.ServiceAccountCredentials;

import java.io.IOException;
import java.io.InputStream;

public class GoogleDriveClient {

    private final ServiceAccountCredentials serviceAccountCredentials;

    public GoogleDriveClient(String fileName) {
        this.serviceAccountCredentials = readServiceAccountCredentialsFromFile(fileName);
    }

    public DirectoryActions getDirectoryActions() {
        return new DirectoryActions(serviceAccountCredentials);
    }

    public FileActions getFileActions() {
        return new FileActions(serviceAccountCredentials);
    }

    private ServiceAccountCredentials readServiceAccountCredentialsFromFile(String resourceName) {
        ServiceAccountCredentials serviceAccountCredentials = null;
        try (InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(resourceName)) {
            if (inputStream != null) {
                serviceAccountCredentials = ServiceAccountCredentials.fromStream(inputStream);
            }
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
        return serviceAccountCredentials;
    }

}

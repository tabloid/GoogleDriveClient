package com.hvo.lib.api;

import com.google.auth.oauth2.ServiceAccountCredentials;

public class GoogleDriveClient {

    private final ServiceAccountCredentials serviceAccountCredentials;

    public GoogleDriveClient(ServiceAccountCredentials serviceAccountCredentials) {
        this.serviceAccountCredentials = serviceAccountCredentials;
    }

    public DirectoryActions getDirectoryActions() {
        return new DirectoryActions(serviceAccountCredentials);
    }

    public FileActions getFileActions() {
        return new FileActions(serviceAccountCredentials);
    }

}

package com.hvo;

import com.hvo.lib.api.DirectoryActions;
import com.hvo.lib.api.FileActions;
import com.hvo.lib.api.GoogleDriveClient;
import com.hvo.lib.directory.create.CreateDirectoryResponse;
import com.hvo.lib.directory.delete.DeleteDirectoryResponse;
import com.hvo.lib.directory.get.GetDirectoryResponse;
import com.hvo.lib.directory.getlist.GetDirectoryListResponse;
import com.hvo.lib.file.create.CreateFileResponse;
import com.hvo.lib.file.get.GetFileResponse;
import com.hvo.lib.file.getlist.GetFileListResponse;

public class App {

    public static void main(String[] args) {
        String resourceName = "gdrive-storage-297122-e20587d1d42a.json";
        GoogleDriveClient client = new GoogleDriveClient(resourceName);

        System.out.println("START DIRECTORY TESTS");
        DirectoryActions directoryActions = client.getDirectoryActions();

        GetDirectoryListResponse getDirectoryListResponse = directoryActions.getDirectoryList();
        String directoryId = getDirectoryListResponse.getFiles().get(0).getId();

        GetDirectoryResponse getDirectoryResponse = directoryActions.getDirectory(directoryId);

        String directoryName = "seva_3";
        CreateDirectoryResponse createDirectoryResponse = directoryActions.createDirectory(directoryName);
        directoryId = createDirectoryResponse.getId();

        DeleteDirectoryResponse deleteDirectoryResponse = directoryActions.deleteDirectory(directoryId);
        System.out.println("END DIRECTORY TESTS");

        System.out.println("START FILE TESTS");
        FileActions fileActions = client.getFileActions();

        GetFileListResponse getFileListResponse = fileActions.getFileList();
        String fileId = getFileListResponse.getFiles().get(0).getId();

        GetFileResponse getFileResponse = fileActions.getFile(fileId);

        // TODO to reimplement
        String fileName = "file_seva_3.test";
        CreateFileResponse createFileResponse = fileActions.createFile(fileName);
        fileId = createFileResponse.getId();
        System.out.println("END FILE TESTS");
    }

}

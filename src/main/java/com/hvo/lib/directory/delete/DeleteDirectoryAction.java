package com.hvo.lib.directory.delete;

import com.hvo.lib.AbstractAction;

class DeleteDirectoryAction extends AbstractAction<DeleteDirectoryResponse> {

    private final String accessToken;
    private final String directoryId;

    DeleteDirectoryAction(String accessToken, String directoryId) {
        this.accessToken = accessToken;
        this.directoryId = directoryId;
    }

    @Override
    public DeleteDirectoryResponse execute() {
        DeleteDirectoryRequest deleteDirectoryRequest = new DeleteDirectoryRequest(accessToken, directoryId);
        return execute(deleteDirectoryRequest, DeleteDirectoryResponse.class);
    }

}

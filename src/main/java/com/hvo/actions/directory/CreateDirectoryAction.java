package com.hvo.actions.directory;

import com.hvo.actions.AbstractAction;
import com.hvo.requests.directory.CreateDirectoryRequest;
import com.hvo.responses.directory.CreateDirectoryResponse;

class CreateDirectoryAction extends AbstractAction<CreateDirectoryResponse> {

    private final String accessToken;
    private final String directoryName;

    CreateDirectoryAction(String accessToken, String directoryName) {
        this.accessToken = accessToken;
        this.directoryName = directoryName;
    }

    @Override
    public CreateDirectoryResponse execute() {
        CreateDirectoryRequest createDirectoryRequest = new CreateDirectoryRequest(accessToken, directoryName);
        return execute(createDirectoryRequest, CreateDirectoryResponse.class);
    }

}

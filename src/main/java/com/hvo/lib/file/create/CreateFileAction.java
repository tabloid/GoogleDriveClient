package com.hvo.lib.file.create;

import com.hvo.lib.core.AbstractAction;

class CreateFileAction extends AbstractAction<CreateFileResponse> {

    private final String accessToken;
    private final String fileName;

    CreateFileAction(String accessToken, String fileName) {
        this.accessToken = accessToken;
        this.fileName = fileName;
    }

    @Override
    public CreateFileResponse execute() {
        CreateFileRequest createFileRequest = new CreateFileRequest(accessToken, fileName);
        return execute(createFileRequest, CreateFileResponse.class);
    }

}

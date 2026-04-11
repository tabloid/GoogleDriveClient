package com.hvo.lib.file.get;

import com.hvo.lib.core.AbstractAction;

class GetFileAction extends AbstractAction<GetFileResponse> {

    private final String accessToken;
    private final String fileId;

    GetFileAction(String accessToken, String fileId) {
        this.accessToken = accessToken;
        this.fileId = fileId;
    }

    @Override
    public GetFileResponse execute() {
        GetFileRequest getFileRequest = new GetFileRequest(accessToken, fileId);
        return execute(getFileRequest, GetFileResponse.class);
    }

}

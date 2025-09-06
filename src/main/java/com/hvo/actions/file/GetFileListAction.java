package com.hvo.actions.file;

import com.hvo.actions.AbstractAction;
import com.hvo.requests.file.GetFileListRequest;
import com.hvo.responses.file.GetFileListResponse;

class GetFileListAction extends AbstractAction<GetFileListResponse> {

    private final String accessToken;

    GetFileListAction(String accessToken) {
        this.accessToken = accessToken;
    }

    @Override
    public GetFileListResponse execute() {
        GetFileListRequest getFileListRequest = new GetFileListRequest(accessToken);
        return execute(getFileListRequest, GetFileListResponse.class);
    }

}

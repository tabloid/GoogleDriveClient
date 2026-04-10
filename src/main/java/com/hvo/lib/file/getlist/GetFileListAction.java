package com.hvo.lib.file.getlist;

import com.hvo.lib.AbstractAction;

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

package com.hvo.actions.directory;

import com.hvo.actions.AbstractAction;
import com.hvo.requests.directory.GetDirectoryListRequest;
import com.hvo.responses.directory.GetDirectoryListResponse;

class GetDirectoryListAction extends AbstractAction<GetDirectoryListResponse> {

    private final String accessToken;

    GetDirectoryListAction(String accessToken) {
        this.accessToken = accessToken;
    }

    @Override
    public GetDirectoryListResponse execute() {
        GetDirectoryListRequest getDirectoryListRequest = new GetDirectoryListRequest(accessToken);
        return execute(getDirectoryListRequest, GetDirectoryListResponse.class);
    }

}

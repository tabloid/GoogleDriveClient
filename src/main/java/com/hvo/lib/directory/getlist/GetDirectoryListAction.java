package com.hvo.lib.directory.getlist;

import com.hvo.lib.core.AbstractAction;

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

package com.hvo.actions.directory;

import com.hvo.actions.AbstractAction;
import com.hvo.requests.directory.GetDirectoryRequest;
import com.hvo.responses.directory.GetDirectoryResponse;

class GetDirectoryAction extends AbstractAction<GetDirectoryResponse> {

    private final String accessToken;
    private final String directoryId;

    GetDirectoryAction(String accessToken, String directoryId) {
        this.accessToken = accessToken;
        this.directoryId = directoryId;
    }

    @Override
    public GetDirectoryResponse execute() {
        GetDirectoryRequest getDirectoryRequest = new GetDirectoryRequest(accessToken, directoryId);
        return execute(getDirectoryRequest, GetDirectoryResponse.class);
    }

}

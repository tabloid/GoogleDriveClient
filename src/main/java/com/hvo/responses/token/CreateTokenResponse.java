package com.hvo.responses.token;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.hvo.responses.AbstractResponse;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(callSuper = true)
public class CreateTokenResponse extends AbstractResponse {

    @JsonProperty("access_token")
    private String accessToken;
    @JsonProperty("expires_in")
    private String expiresIn;
    @JsonProperty("token_type")
    private String tokenType;

}

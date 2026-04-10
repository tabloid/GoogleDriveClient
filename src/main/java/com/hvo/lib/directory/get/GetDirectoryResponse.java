package com.hvo.lib.directory.get;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.hvo.lib.AbstractResponse;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(callSuper = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class GetDirectoryResponse extends AbstractResponse {

    private String kind;
    private String id;
    private String name;
    private String mimeType;

}

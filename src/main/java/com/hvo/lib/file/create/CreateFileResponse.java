package com.hvo.lib.file.create;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.hvo.lib.core.AbstractResponse;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(callSuper = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class CreateFileResponse extends AbstractResponse {

    private String kind;
    private String id;
    private String name;
    private String mimeType;

}

package com.hvo.responses.directory;

import com.hvo.models.File;
import com.hvo.responses.AbstractResponse;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString(callSuper = true)
public class GetDirectoryListResponse extends AbstractResponse {

    private String kind;
    private boolean incompleteSearch;
    private List<File> files;

}

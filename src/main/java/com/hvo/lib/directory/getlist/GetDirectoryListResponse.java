package com.hvo.lib.directory.getlist;

import com.hvo.lib.model.File;
import com.hvo.lib.core.AbstractResponse;
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

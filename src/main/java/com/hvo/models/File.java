package com.hvo.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class File {
    private String kind;
    private String id;
    private String name;
    private String mimeType;
}

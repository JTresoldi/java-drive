package com.tresoldi.drive.library.dto;

public class CreateFolderRequest {
    private String name;
    private Long parentId;

    public String getName() {
        return name;
    }

    public Long getParentId() {
        return parentId;
    }
}

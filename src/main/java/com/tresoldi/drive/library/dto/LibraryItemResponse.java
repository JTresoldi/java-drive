package com.tresoldi.drive.library.dto;

import com.tresoldi.drive.library.model.LibraryItem;

import java.time.LocalDateTime;

public class LibraryItemResponse {
    private Long id;
    private String name;
    private String type;
    private Long parentId;
    private String mimeType;
    private Long sizeBytes;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public static LibraryItemResponse from(LibraryItem item) {
        LibraryItemResponse response = new LibraryItemResponse();

        response.setId(item.getId());
        response.setName(item.getName());
        response.setType(item.getType().name());
        response.setParentId(item.getParent() != null ? item.getParent().getId() : null);
        response.setMimeType(item.getMimeType());
        response.setSizeBytes(item.getSizeBytes());
        response.setCreatedAt(item.getCreatedAt());
        response.setUpdatedAt(item.getUpdatedAt());

        return response;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMimeType() {
        return mimeType;
    }

    public void setMimeType(String mimeType) {
        this.mimeType = mimeType;
    }

    public Long getSizeBytes() {
        return sizeBytes;
    }

    public void setSizeBytes(Long sizeBytes) {
        this.sizeBytes = sizeBytes;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}

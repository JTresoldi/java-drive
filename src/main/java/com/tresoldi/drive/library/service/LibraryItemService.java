package com.tresoldi.drive.library.service;

import com.tresoldi.drive.library.dto.LibraryItemResponse;
import com.tresoldi.drive.library.model.LibraryItem;
import com.tresoldi.drive.library.repository.LibraryItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibraryItemService {
    private final LibraryItemRepository repository;

    public LibraryItemService(LibraryItemRepository repository) {
        this.repository = repository;
    }

    public List<LibraryItemResponse> listItems(Long folderId) {
        List<LibraryItem> items;

        if (folderId == null) {
            items = repository.findByParentIsNullAndDeletedAtIsNullOrderByTypeAscNameAsc();
        } else {
            items = repository.findByParentIdAndDeletedAtIsNullOrderByTypeAscNameAsc(folderId);
        }

        return items.stream()
                .map(LibraryItemResponse::from)
                .toList();
    }
}

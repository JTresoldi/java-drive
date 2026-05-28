package com.tresoldi.drive.library.service;

import com.tresoldi.drive.library.dto.CreateFolderRequest;
import com.tresoldi.drive.library.dto.LibraryItemResponse;
import com.tresoldi.drive.library.model.LibraryItem;
import com.tresoldi.drive.library.model.LibraryItemType;
import com.tresoldi.drive.library.repository.LibraryItemRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
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

    public LibraryItemResponse createFolder(CreateFolderRequest request) {
        LibraryItem parent = null;

        if (request.getParentId() != null) {
            parent = repository.findByIdAndDeletedAtIsNull(request.getParentId())
                    .orElseThrow(() -> new RuntimeException("Pasta pai não encontrada."));

            if (!parent.isFolder()) {
                throw new RuntimeException("O item pai precisa ser uma pasta.");
            }
        }

        LibraryItem folder = new LibraryItem();

        folder.setName(request.getName());
        folder.setType(LibraryItemType.FOLDER);
        folder.setParent(parent);
        folder.setCreatedBy(1L);
        folder.setUpdatedBy(1L);
        folder.setCreatedAt(LocalDateTime.now());


        LibraryItem savedFolder = repository.save(folder);

        return LibraryItemResponse.from(savedFolder);
    }
}

package com.tresoldi.drive.library.controller;

import com.tresoldi.drive.library.dto.CreateFolderRequest;
import com.tresoldi.drive.library.dto.LibraryItemResponse;
import com.tresoldi.drive.library.service.LibraryItemService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins =  "http://localhost:5173")
@RestController
@RequestMapping("/api/library")
public class LibraryItemController {
    private final LibraryItemService service;

    public LibraryItemController(LibraryItemService service) {
        this.service = service;
    }

    @GetMapping("/items")
    public List<LibraryItemResponse> listItems(@RequestParam(required = false) Long folderId) {
        return service.listItems(folderId);
    }

    @PostMapping("/folders")
    public LibraryItemResponse createFolder(@RequestBody CreateFolderRequest request) {
        return service.createFolder(request);
    }
}

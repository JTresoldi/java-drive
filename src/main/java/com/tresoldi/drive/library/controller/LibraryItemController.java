package com.tresoldi.drive.library.controller;

import com.tresoldi.drive.library.dto.LibraryItemResponse;
import com.tresoldi.drive.library.service.LibraryItemService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
}

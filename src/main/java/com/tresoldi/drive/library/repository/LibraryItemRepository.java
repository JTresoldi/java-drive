package com.tresoldi.drive.library.repository;

import com.tresoldi.drive.library.model.LibraryItem;
import com.tresoldi.drive.library.model.LibraryItemType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface LibraryItemRepository extends JpaRepository<LibraryItem, Long> {

    List<LibraryItem> findByParentIsNullAndDeletedAtIsNullOrderByTypeAscNameAsc();

    List<LibraryItem> findByParentIdAndDeletedAtIsNullOrderByTypeAscNameAsc(Long parentId);

    Optional<LibraryItem> findByIdAndDeletedAtIsNull(Long id);

    boolean existsByParentIdAndNameIgnoreCaseAndDeletedAtIsNull(Long parentId, String name);

    boolean existsByParentIsNullAndNameIgnoreCaseAndDeletedAtIsNull(String name);

    long countByParentIdAndTypeAndDeletedAtIsNull(Long parentId, LibraryItemType type);
}
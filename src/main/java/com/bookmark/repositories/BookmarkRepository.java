package com.bookmark.repositories;

import com.bookmark.models.Bookmark;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookmarkRepository extends JpaRepository<Bookmark, Long> {
    List<Bookmark> findByUserId(String userId);
    Bookmark findByUserIdAndId(String userId, Long id);
}

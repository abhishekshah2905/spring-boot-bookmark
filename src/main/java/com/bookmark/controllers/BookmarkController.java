package com.bookmark.controllers;

import com.bookmark.models.Bookmark;
import com.bookmark.models.types.BookmarkType;
import com.bookmark.repositories.BookmarkRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@RestController
@RequiredArgsConstructor(onConstructor = @_(@Autowired))
public class BookmarkController {

    private final BookmarkRepository bookmarkRepository;

    @GetMapping("/{userId}/bookmarks")
    Collection<Bookmark> getBookmarks(@PathVariable String userId) {
        List<Bookmark> bookmarks = this.bookmarkRepository.findByUserId(userId);
        return bookmarks;
    }

    @GetMapping("/{userId}/bookmarks/{bookmarkId}")
    Bookmark getBookmark(@PathVariable String userId,
                         @PathVariable Long bookmarkId) {
        Bookmark bookmark = this.bookmarkRepository.findByUserIdAndId(userId, bookmarkId);
        BookmarkType bookmarkType = (bookmarkId % 2 == 0) ? BookmarkType.COMPLEX : BookmarkType.GENERAL;
        bookmark.setBookmarkTypes(Arrays.asList(bookmarkType));
        return bookmark;
    }

    @PostMapping("/{userId}/bookmarks")
    Bookmark createBookmark(@PathVariable String userId,
                            @RequestBody Bookmark bookmark) {

        Bookmark bookmarkInstance = new Bookmark(
                userId,
                bookmark.getHref(),
                bookmark.getDescription(),
                bookmark.getLabel());

        return this.bookmarkRepository.save(bookmarkInstance);
    }
}

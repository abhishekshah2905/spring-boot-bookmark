package com.bookmark.controllers

import com.bookmark.controllers.BookmarkController
import com.bookmark.repositories.BookmarkRepository
import spock.lang.Specification

class BookmarkControllerTest extends Specification {

    BookmarkController bookmarkController

    BookmarkRepository bookmarkRepository

    void setup() {
        bookmarkRepository = Mock()
        bookmarkController = new BookmarkController(bookmarkRepository)
    }

    def "Get bookmarks with userId" () {
        given:
        def userId = "abhishek"
        def bookmarks = []
        bookmarkRepository.findByUserId(userId) >> bookmarks

        when:
        def response = bookmarkController.getBookmarks(userId)

        then:
        response == []

        1 * bookmarkRepository.findByUserId(userId) >> bookmarks
        0 * _
    }
}

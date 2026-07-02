package com.library.repository;

public class BookRepository {
    public String getBookTitleById(int id) {
        if (id == 1) {
            return "Introduction to Spring";
        }
        return "Unknown Book";
    }
}

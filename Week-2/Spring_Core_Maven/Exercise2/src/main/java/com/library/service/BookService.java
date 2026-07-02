package com.library.service;

import com.library.repository.BookRepository;

public class BookService {
    private BookRepository bookRepository;

    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void showBookDetails(int id) {
        String title = bookRepository.getBookTitleById(id);
        System.out.println("Book Title: " + title);
    }
}

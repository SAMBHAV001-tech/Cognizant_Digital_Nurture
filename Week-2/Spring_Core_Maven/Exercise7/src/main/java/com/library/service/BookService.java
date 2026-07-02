package com.library.service;

import com.library.repository.BookRepository;

public class BookService {
    private final BookRepository bookRepository;
    private EmailService emailService;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void setEmailService(EmailService emailService) {
        this.emailService = emailService;
    }

    public void manageLibrary() {
        bookRepository.getBooks();
        if (emailService != null) {
            emailService.sendEmailAlert("Library operations started successfully");
        }
    }
}

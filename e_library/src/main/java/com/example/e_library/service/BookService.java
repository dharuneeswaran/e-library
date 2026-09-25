package com.example.e_library.service;

import com.example.e_library.model.Book;
import com.example.e_library.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Book addBook(Book book) {
        return bookRepository.save(Objects.requireNonNull(book, "book must not be null"));
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Optional<Book> getBookById(int id) {
        return bookRepository.findById(id);
    }

    public Book updateBook(int id, Book book) {

        Book existingBook = bookRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Book not found"));

        existingBook.setTitle(book.getTitle());
        existingBook.setAuthor(book.getAuthor());
        existingBook.setIsbn(book.getIsbn());
        existingBook.setLanguage(book.getLanguage());
        existingBook.setDescription(book.getDescription());
        existingBook.setFileUrl(book.getFileUrl());
        existingBook.setStatus(book.getStatus());
        existingBook.setCategoryId(book.getCategoryId());

        return bookRepository.save(existingBook);
    }

    public void deleteBook(int id) {
        bookRepository.deleteById(id);
    }
}

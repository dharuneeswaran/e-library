package com.example.e_library.controller;

import com.example.e_library.model.Book;
import com.example.e_library.service.BookService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping
    public Book addBook(@RequestBody Book book) {
        return bookService.addBook(book);
    }

    @GetMapping
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @GetMapping("/{id}")
    public Optional<Book> getBookById(@PathVariable int id) {
        return bookService.getBookById(id);
    }

    @PutMapping("/{id}")
    public Book updateBook(
            @PathVariable int id,
            @RequestBody Book book) {

        return bookService.updateBook(id, book);
    }

    @DeleteMapping("/{id}")
    public String deleteBook(@PathVariable int id) {

        bookService.deleteBook(id);

        return "Book deleted successfully";
    }
}

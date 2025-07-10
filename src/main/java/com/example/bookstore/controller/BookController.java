package com.example.bookstore.controller;

import com.example.bookstore.model.Book;
import com.example.bookstore.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import static com.example.bookstore.repository.SpecificationUtils.*;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/books")
@Tag(name = "Book Management", description = "APIs for creating, retrieving, and managing books")
public class BookController {

    @Autowired
    private BookRepository bookRepository;


    @PostMapping
    public Book createBook(@RequestBody Book book) {
        return bookRepository.save(book);
    }

    @Operation(summary = "Get a list of books with optional filters",
            description = "Returns a paginated list of books. Can be filtered by title, publication year, and author name.")
    @ApiResponse(responseCode = "200", description = "Successfully retrieved list")
    @GetMapping
    public Page<Book> getBooks(
            @RequestParam(required = false) String title,
            @RequestParam(required = false) Integer year,
            @RequestParam(required = false) String authorName,
            Pageable pageable) {

        Specification<Book> spec = Specification.where(null);

        if (title != null) {
            spec = spec.and(hasTitle(title));
        }
        if (year != null) {
            spec = spec.and(publishedInYear(year));
        }
        if (authorName != null) {
            spec = spec.and(hasAuthor(authorName));
        }

        return bookRepository.findAll(spec, pageable);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable Long id) {
        return bookRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
        return bookRepository.findById(id)
                .map(book -> {
                    bookRepository.delete(book);
                    return ResponseEntity.ok().<Void>build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
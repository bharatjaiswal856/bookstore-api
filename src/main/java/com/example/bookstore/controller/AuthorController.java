package com.example.bookstore.controller;

import com.example.bookstore.dto.AuthorDto;
import com.example.bookstore.dto.CreateAuthorRequestDto;
import com.example.bookstore.service.AuthorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/authors")
@Tag(name = "Author Management System", description = "Operations pertaining to authors in Bookstore")
public class AuthorController {

    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @Operation(summary = "Create a new author")
    @PostMapping
    public ResponseEntity<AuthorDto> createAuthor(@Valid @RequestBody CreateAuthorRequestDto requestDto) {
        AuthorDto createdAuthor = authorService.createAuthor(requestDto);
        return new ResponseEntity<>(createdAuthor, HttpStatus.CREATED);
    }

    @Operation(summary = "Get a list of all authors (paginated)")
    @GetMapping
    public Page<AuthorDto> getAllAuthors(Pageable pageable) {
        return authorService.getAllAuthors(pageable);
    }

    @Operation(summary = "Get an author by ID")
    @GetMapping("/{id}")
    public ResponseEntity<AuthorDto> getAuthorById(@PathVariable Long id) {
        AuthorDto authorDto = authorService.getAuthorById(id);
        return ResponseEntity.ok(authorDto);
    }

    @Operation(summary = "Update an existing author")
    @PutMapping("/{id}")
    public ResponseEntity<AuthorDto> updateAuthor(@PathVariable Long id, @Valid @RequestBody CreateAuthorRequestDto requestDto) {
        AuthorDto updatedAuthor = authorService.updateAuthor(id, requestDto);
        return ResponseEntity.ok(updatedAuthor);
    }

    @Operation(summary = "Delete an author")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAuthor(@PathVariable Long id) {
        authorService.deleteAuthor(id);
        return ResponseEntity.noContent().build();
    }
}
package com.example.bookstore.dto;

import lombok.Data;

@Data
public class BookDto {
    private Long id;
    private String title;
    private String isbn;
    private int publicationYear;
    private AuthorDto author; // Use an AuthorDto, not the entity
}
package com.example.bookstore.dto;

import lombok.Data;

@Data
public class AuthorDto {
    private Long id;
    private String name;
    private String biography;
}
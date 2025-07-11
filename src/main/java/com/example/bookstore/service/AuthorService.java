package com.example.bookstore.service;
import com.example.bookstore.dto.AuthorDto;
import com.example.bookstore.dto.CreateAuthorRequestDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface AuthorService {
    AuthorDto createAuthor(CreateAuthorRequestDto requestDto);
    Page<AuthorDto> getAllAuthors(Pageable pageable);
    AuthorDto getAuthorById(Long id);
    AuthorDto updateAuthor(Long id, CreateAuthorRequestDto requestDto);
    void deleteAuthor(Long id);
}
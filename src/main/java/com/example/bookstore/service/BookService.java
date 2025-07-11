package com.example.bookstore.service;
import com.example.bookstore.dto.BookDto;
import com.example.bookstore.dto.CreateBookRequestDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BookService {
    BookDto createBook(CreateBookRequestDto requestDto);
    Page<BookDto> getAllBooks(Pageable pageable);
    BookDto getBookById(Long id);
    BookDto updateBook(Long id, CreateBookRequestDto requestDto);
    void deleteBook(Long id);
}
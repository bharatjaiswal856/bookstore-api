package com.example.bookstore.mapper;
import com.example.bookstore.dto.AuthorDto;
import com.example.bookstore.dto.CreateAuthorRequestDto;
import com.example.bookstore.model.Author;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AuthorMapper {
    AuthorDto toAuthorDto(Author author);
    Author toAuthor(CreateAuthorRequestDto createAuthorRequestDto);
}
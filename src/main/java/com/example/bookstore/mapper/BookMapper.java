package com.example.bookstore.mapper;
import com.example.bookstore.dto.BookDto;
import com.example.bookstore.model.Book;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {AuthorMapper.class})
public interface BookMapper {
    BookDto toBookDto(Book book);
}
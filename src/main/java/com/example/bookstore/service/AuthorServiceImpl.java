package com.example.bookstore.service;
import com.example.bookstore.dto.AuthorDto;
import com.example.bookstore.dto.CreateAuthorRequestDto;
import com.example.bookstore.exception.ResourceNotFoundException;
import com.example.bookstore.mapper.AuthorMapper;
import com.example.bookstore.model.Author;
import com.example.bookstore.repository.AuthorRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class AuthorServiceImpl implements AuthorService {
    private final AuthorRepository authorRepository;
    private final AuthorMapper authorMapper;

    public AuthorServiceImpl(AuthorRepository authorRepository, AuthorMapper authorMapper) {
        this.authorRepository = authorRepository;
        this.authorMapper = authorMapper;
    }

    @Override
    public AuthorDto createAuthor(CreateAuthorRequestDto requestDto) {
        Author author = authorMapper.toAuthor(requestDto);
        Author savedAuthor = authorRepository.save(author);
        return authorMapper.toAuthorDto(savedAuthor);
    }

    @Override
    public Page<AuthorDto> getAllAuthors(Pageable pageable) {
        return authorRepository.findAll(pageable).map(authorMapper::toAuthorDto);
    }

    @Override
    public AuthorDto getAuthorById(Long id) {
        Author author = authorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Author not found with id: " + id));
        return authorMapper.toAuthorDto(author);
    }

    @Override
    public AuthorDto updateAuthor(Long id, CreateAuthorRequestDto requestDto) {
        Author author = authorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Author not found with id: " + id));
        author.setName(requestDto.getName());
        author.setBiography(requestDto.getBiography());
        Author updatedAuthor = authorRepository.save(author);
        return authorMapper.toAuthorDto(updatedAuthor);
    }

    @Override
    public void deleteAuthor(Long id) {
        if (!authorRepository.existsById(id)) {
            throw new ResourceNotFoundException("Author not found with id: " + id);
        }
        authorRepository.deleteById(id);
    }
}
package com.example.bookstore.repository;

import com.example.bookstore.model.Author;
import com.example.bookstore.model.Book;
import jakarta.persistence.criteria.Join;
import org.springframework.data.jpa.domain.Specification;

public class SpecificationUtils {
    public static Specification<Book> hasTitle(String title) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.like(root.get("title"), "%" + title + "%");
    }

    public static Specification<Book> publishedInYear(int year) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.equal(root.get("publicationYear"), year);
    }

    public static Specification<Book> hasAuthor(String authorName) {
        return (root, query, criteriaBuilder) -> {
            Join<Book, Author> authorJoin = root.join("author");
            return criteriaBuilder.like(authorJoin.get("name"), "%" + authorName + "%");
        };
    }
}
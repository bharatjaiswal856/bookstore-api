package com.example.bookstore.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Set;
import com.fasterxml.jackson.annotation.JsonManagedReference;


@Entity
@Data // Lombok: Generates getters, setters, toString, etc.
@NoArgsConstructor
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    private String biography;

    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference // Prevents infinite recursion in JSON serialization
    private Set<Book> books;
}
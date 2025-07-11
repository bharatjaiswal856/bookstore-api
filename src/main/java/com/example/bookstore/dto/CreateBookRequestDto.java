package com.example.bookstore.dto;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
@Data
public class CreateBookRequestDto {
    @NotBlank(message = "Title is mandatory")
    private String title;
    @NotBlank(message = "ISBN is mandatory")
    private String isbn;
    @Min(value = 1000)
    private int publicationYear;
    @NotNull(message = "Author ID is mandatory")
    private Long authorId;
}
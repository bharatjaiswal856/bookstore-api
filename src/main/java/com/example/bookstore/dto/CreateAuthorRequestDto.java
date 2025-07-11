package com.example.bookstore.dto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
@Data
public class CreateAuthorRequestDto {
    @NotBlank(message = "Author name cannot be blank")
    @Size(min = 2, max = 100)
    private String name;
    @Size(max = 5000)
    private String biography;
}
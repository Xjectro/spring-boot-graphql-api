package com.example.demo.dto;

import lombok.*;
import jakarta.validation.constraints.*;

@Getter @Setter @NoArgsConstructor
public class UpdateUserInput {
    @NotNull(message = "ID is required")
    private Long id;
    
    @Size(min = 3, max = 50, message = "Username must be between 3 and 50 characters")
    private String username;
}

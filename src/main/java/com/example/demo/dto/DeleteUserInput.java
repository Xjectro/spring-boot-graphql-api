package com.example.demo.dto;

import lombok.*;
import jakarta.validation.constraints.*;

@Getter @Setter @NoArgsConstructor
public class DeleteUserInput {
    @NotNull(message = "ID is required")
    private Long id;
}

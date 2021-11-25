package com.example;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

public record User(
        @NotBlank String name,
        @Min(1) int age
) {
}

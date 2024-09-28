package com.github.cokothon.domain.user.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record ChangePasswordRequest(

        @NotBlank
        String password,

        @NotBlank
        @Pattern(regexp = "^(?=.*[a-zA-Z])(?=.*\\d)\\S{8,}$")
        String newPassword
) {
}
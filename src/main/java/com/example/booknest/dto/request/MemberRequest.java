package com.example.booknest.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record MemberRequest(@NotBlank (message = "Name is Required")String name,
@NotBlank (message = "Email is Required") @Email(message = "Invalid Email format") String email) {
}
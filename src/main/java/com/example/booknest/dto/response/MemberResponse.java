package com.example.booknest.dto.response;

/**
 * MemberResponse
 */
public record MemberResponse(
    Long id,
    String name,
    String email
) {
}
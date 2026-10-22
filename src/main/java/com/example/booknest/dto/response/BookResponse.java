package com.example.booknest.dto.response;

/**
 * BookResponse
 */
public record BookResponse(
    Long id,
    String title,
    String author,
    String isbn,
    int quantity
) {
}
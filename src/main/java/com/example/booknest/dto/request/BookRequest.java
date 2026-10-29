package com.example.booknest.dto.request;

public record BookRequest(
    String isbn,
    String title,
    String author,
    String category,
    int totalCopies,
    int availableCopies
) {
}

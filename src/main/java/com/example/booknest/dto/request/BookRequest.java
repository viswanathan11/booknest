package com.example.booknest.dto.request;

public record BookRequest(
    String title,
    String author,
    String isbn,
    int quantity
) {
    
}

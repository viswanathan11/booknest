package com.example.booknest.Exception;

import java.time.LocalDateTime;

/**
 * ResourceNotFoundException
 */
public record ResourceNotFoundException(LocalDateTime timestamp,int status,String message,String path) {
}
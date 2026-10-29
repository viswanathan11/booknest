package com.example.booknest.dto.response;

import java.time.LocalDateTime;

public record ReturnResponse(LocalDateTime timeAt,String message,) {
    
}

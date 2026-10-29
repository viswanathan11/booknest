package com.example.booknest.Exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.servlet.http.HttpServletRequest;

@RestControllerAdvice 
public class GlobalExceptionHandler {
    
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorDto> handleNotFound(ResourceNotFoundException ex,HttpServletRequest request){
        ErrorDto error=new ErrorDto(LocalDateTime.now(),404,ex.getMessage(),request.getRequestURI());
        return ResponseEntity.status(404).body(error);
    }

    @ExceptionHandler(BuisnessException.class)
    public ResponseEntity<ErrorDto> handleBuinsessError(BuisnessException ex){
        ErrorDto error =new ErrorDto(LocalDateTime.now(),500,);
        return ResponseEntity.status(HttpStatus.CONFLICT).body(error));
    }
}

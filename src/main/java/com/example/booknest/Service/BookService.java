package com.example.booknest.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.booknest.Entity.Book;
import com.example.booknest.Repository.BookRepository;

@Service 
public class BookService {
    @Autowired 
    BookRepository bookRepository;

    public List<Book> getAllBooks(){
        return bookRepository.findAll();
    }

    public Book getBookById(Long id){
        return bookRepository.findById(id).orElseThrow(()-> new RuntimeException("Book not found"));
    }
    
    public void deleteBook( Long id){
        bookRepository.deleteById(id);
    }
}

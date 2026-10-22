package com.example.booknest.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.booknest.Entity.Book;



public interface  BookRepository extends JpaRepository<Book,Long> {
    
}

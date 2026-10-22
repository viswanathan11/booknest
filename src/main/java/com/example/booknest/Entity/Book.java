package com.example.booknest.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity 
@NoArgsConstructor 
@Getter 
@Setter
public class Book {
    @Id 
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long bookId;

    private String isbn;
    private String title;
    private String author;
    private String category;
    private int totalCopies;
    private int availableCopies;

    Book(String isbn,String title,String author,String category,int totalCopies,int availableCopies){
        this.isbn=isbn;
        this.author=author;
        this.category=category;
        this.totalCopies=totalCopies;
        this.availableCopies=availableCopies;
    }
}

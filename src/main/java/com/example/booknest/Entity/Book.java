package com.example.booknest.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity 
@Table (name="books")
@NoArgsConstructor 
@Getter 
@Setter
public class Book {
    @Id 
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column (nullable = false,unique = true)
    private String isbn;

    @Column(nullable = false)
    private String title;
    private String author;
    private String category;
    private int totalCopies;
    private int availableCopies;

    public Book(String isbn,String title,String author,String category,int totalCopies,int availableCopies){
        this.isbn=isbn;
        this.title=title;
        this.author=author;
        this.category=category;
        this.totalCopies=totalCopies;
        this.availableCopies=availableCopies;
    }
}

package com.example.booknest.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.booknest.Entity.Book;
import com.example.booknest.Repository.BookRepository;

@Service 
public class BookService {
  
    BookRepository bookRepository;
    public BookService(BookRepository bookRepository){
        this.bookRepository=bookRepository;
    }
    public List<Book> getAllBooks(){
        return bookRepository.findAll();
    }

    public Book getBookById(Long id){
        return bookRepository.findById(id).orElseThrow(()-> new RuntimeException("Book not found"));
    }
    
    public void deleteBook( Long id){
        bookRepository.deleteById(id);
    }

    public Book createBook(Book book){
        return bookRepository.save(book);
    }

    public boolean updateBook(Book book){
        Book newBook=new Book(book.getIsbn(),book.getTitle(),book.getAuthor(),book.getCategory(),book.getTotalCopies(),book.getAvailableCopies());
        newBook.setId(book.getId());
        if(!bookRepository.existsById(book.getId())){
            return false;
        }else{
            bookRepository.save(newBook);
            return true;
        }

    }
}

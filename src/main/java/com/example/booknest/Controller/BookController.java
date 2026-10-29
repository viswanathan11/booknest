package com.example.booknest.Controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.booknest.Entity.Book;
import com.example.booknest.Service.BookService;
import com.example.booknest.dto.request.BookRequest;
import com.example.booknest.dto.response.BookResponse;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.web.bind.annotation.RequestBody ;

@RestController 
@RequestMapping ("/api/book")
@Tag (name="Books",description = "Book catalog management")
public class BookController {
    private  final BookService bookService;
    public BookController(BookService bookService){
        this.bookService=bookService;
    }

    @PostMapping 
    @Operation (summary = "Add a new book to catalog")
    public ResponseEntity<BookResponse> addbook( @RequestBody BookRequest bookRequest){

        Book book=new Book(bookRequest.isbn(),bookRequest.title(),bookRequest.author(),bookRequest.category(),bookRequest.totalCopies(),bookRequest.availableCopies());

        bookService.createBook(book);
        BookResponse bookResponse=new BookResponse(book.getBookId(),book.getTitle(),book.getAuthor(),book.getIsbn(),book.getTotalCopies());
        return ResponseEntity.ok(bookResponse);
    }


    @GetMapping ("/{id}")
    @Operation (summary ="Get a book by ID")
    public ResponseEntity<BookResponse> getBook(@PathVariable  Long id){
        Book book=bookService.getBookById(id);

        BookResponse bookRespons=new BookResponse(book.getBookId(),book.getTitle(),book.getAuthor(),book.getIsbn(),book.getTotalCopies());

        return ResponseEntity.ok(bookRespons);
    }


    @GetMapping 
    @Operation (summary = "List all books")
    public ResponseEntity<List<BookResponse>> getBook(){

        List<BookResponse> books=bookService.getAllBooks().stream().map(m->new BookResponse(m.getBookId(),m.getTitle(),m.getAuthor(),m.getIsbn(),m.getTotalCopies())).toList();

        return ResponseEntity.ok(books);
    }


}

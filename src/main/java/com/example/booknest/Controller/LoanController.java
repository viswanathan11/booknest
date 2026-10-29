package com.example.booknest.Controller;

import   com.example.booknest.Entity.Member;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.booknest.Entity.Book;
import com.example.booknest.Entity.Loan;
import com.example.booknest.Service.LoanService;

import com.example.booknest.dto.request.LoanRequest;
import com.example.booknest.dto.response.BookResponse;
import com.example.booknest.dto.response.LoanResponse;
import com.example.booknest.dto.response.MemberResponse;

import io.swagger.v3.oas.annotations.Operation;

@RestController 
@RequestMapping ("/api/loans")
public class LoanController {

    private final LoanService loanService;
 
    public LoanController(LoanService loanService){
        this.loanService=loanService;
    }
    @PostMapping 
    @Operation (summary="Borrowed book")
    public ResponseEntity<LoanResponse> borrow(@RequestBody LoanRequest loanRequest){
        Loan loan=loanService.borrowBook(loanRequest.memberId(),loanRequest.bookId());
        Book book=loan.getBook();
        Member member=loan.getMember();
        
        BookResponse bookRespons=new BookResponse(book.getBookId(),book.getTitle(),book.getAuthor(),book.getIsbn(),book.getTotalCopies());
        MemberResponse memberesponse=new MemberResponse(member.getMemberId(),member.getName(),member.getEmail());
        LoanResponse loanResponse=new LoanResponse(loan.getLoanId(),bookRespons,memberesponse,loan.getLoanStatus());

        return ResponseEntity.status(HttpStatus.CREATED).body(loanResponse);
        }


        @PostMapping ("/{id}/return")
        @Operation(summary = "Return a borrowed book")
        public ResponseEntity<LoanResponse> returnBook(@PathVariable Long id){
            Loan loan=loanService.returnBook(id);

            Book book=loan.getBook();
            Member member=loan.getMember(); 
            BookResponse bookRespons=new BookResponse(book.getBookId(),book.getTitle(),book.getAuthor(),book.getIsbn(),book.getTotalCopies());
            MemberResponse memberesponse=new MemberResponse(member.getMemberId(),member.getName(),member.getEmail());
            LoanResponse loanResponse=new LoanResponse(loan.getLoanId(),bookRespons,memberesponse,loan.getLoanStatus());

            return ResponseEntity.ok(loanResponse);
            
        }
}

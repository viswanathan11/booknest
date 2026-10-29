package com.example.booknest.Service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.booknest.Entity.Book;
import com.example.booknest.Entity.Loan;
import com.example.booknest.Entity.LoanStatus;
import com.example.booknest.Entity.Member;
import com.example.booknest.Exception.BuisnessException;
import com.example.booknest.Exception.ResourceNotFoundException;
import com.example.booknest.Repository.BookRepository;
import com.example.booknest.Repository.LoanRepository;
import com.example.booknest.Repository.MemberRepository;



@Service 
public class LoanService {
    @Autowired 
    LoanRepository loanRepository;
    @Autowired 
    MemberRepository memberRepository;
    @Autowired 
    BookRepository bookRepository;

    public LoanService(LoanRepository loanRepository,MemberRepository memberRepository,BookRepository bookRepository){
      this.loanRepository=loanRepository;
      this.memberRepository=memberRepository;
      this.bookRepository=bookRepository;
    }
    @Value("${app.library.loan-days}")
    private  int loanDays;
    @Value("${app.max-active-loans}")
    private int maxActiveLoans;

    @Transactional 
    public Loan borrowBook(Long memberId,Long bookId){

        Member member=memberRepository.findById(memberId).orElseThrow(()->new ResourceNotFoundException("Member not find with ID "+memberId));

        Book
         book=bookRepository.findById(bookId).orElseThrow(()->new ResourceNotFoundException("Book not found with ID "+bookId));
         LocalDate today=LocalDate.now();
         Loan loan=new Loan(member,book,today,today.plusDays(loanDays),null,LoanStatus.ACTIVE);
         if(book.getAvailableCopies()<=0){
            throw new ResourceNotFoundException("Book not available");
         }

         long activeLoans=loanRepository.countByMemberIdAndLoanStatus(memberId, LoanStatus.ACTIVE);
         if(activeLoans>=maxActiveLoans){
            throw new RuntimeException("Member has reached the maximum active laons");
         }
         book.setAvailableCopies(book.getAvailableCopies()-1);
         bookRepository.save(book);
         return loanRepository.save(loan);
    }

    @Transactional
    public Loan returnBook(Long loanId){
      Loan loan=loanRepository.findById(loanId).orElseThrow(()-> new ResourceNotFoundException("The Loan does not exist"));
      if(loan.getLoanStatus()==LoanStatus.RETURNED){
         throw new BuisnessException("The Book has Already returned");
      }

      Book book=loan.getBook();
      book.setAvailableCopies(book.getAvailableCopies()+1);
      bookRepository.save(book);
      loan.setLoanStatus(LoanStatus.RETURNED);
      loan.setReturnedAt(LocalDate.now());
      
   return loanRepository.save(loan);
    }
}

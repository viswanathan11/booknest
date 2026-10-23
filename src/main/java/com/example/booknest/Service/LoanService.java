package com.example.booknest.Service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.booknest.Entity.Book;
import com.example.booknest.Entity.Loan;
import com.example.booknest.Entity.LoanStatus;
import com.example.booknest.Entity.Member;
import com.example.booknest.Exception.ResourceNotFoundException;
import com.example.booknest.Repository.BookRepository;
import com.example.booknest.Repository.LoanRepository;
import com.example.booknest.Repository.MemberRepository;

@Service 
public class LoanService {
    @Autowired 
    LoanRepository loanRepository;
    MemberRepository memberRepository;
    BookRepository bookRepository;
    public Loan borrowBook(Long memberId,Long bookId){

        Member member=memberRepository.findById(memberId).orElseThrow(()->new ResourceNotFoundException("Member not find with ID "+memberId));

        Book
         book=bookRepository.findById(bookId).orElseThrow(()->new ResourceNotFoundException("Book not found with ID "+bookId));
         LocalDate today=LocalDate.now();
         Loan loan=new Loan(member,book,LocalDate.now(),today,today.plusDays(5),null,LoanStatus.ACTIVE);

    }
}

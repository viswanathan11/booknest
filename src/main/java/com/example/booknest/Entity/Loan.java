package com.example.booknest.Entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity 
@NoArgsConstructor 
@Getter 
@Setter 
public class Loan {
    @Id 
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long LoanId;

    @ManyToOne
    private Member member;

    @ManyToOne 
    private Book book;

    private LocalDate borrowedAt;
    private LocalDate dueDate;
    private LocalDate returnedAt;

    @Enumerated (EnumType.STRING)
    private LoanStatus loanStatus;
    
    public Loan(Member member,Book book,LocalDate borrowedAt,LocalDate dueDate,LocalDate returnedAt,LoanStatus loanStatus){
        this.member=member;
        this.book=book;
        this.borrowedAt=borrowedAt;
        this.dueDate=dueDate;
        this.returnedAt=returnedAt;
        this.loanStatus=loanStatus;
    }
}

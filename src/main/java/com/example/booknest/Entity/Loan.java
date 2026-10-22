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
import lombok.NoArgsConstructor;

@Entity 
@NoArgsConstructor 
public class Loan {
    @Id 
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long LoanId;

    @ManyToOne
    @JoinColumn (name="memberId")
    private Long memberId;

    @ManyToOne 
    @JoinColumn (name = "bookId")
    private Long bookId;

    private LocalDate borrowedAt;
    private LocalDate dueDate;
    private LocalDate returnedAt;

    @Enumerated (EnumType.STRING)
    private LoanStatus loanStatus;
    
    public Loan(Long memberId,Long bookId,LocalDate borrowedAt,LocalDate dueDate,LocalDate returnedAt){
        this.memberId=memberId;
        this.bookId=bookId;
        this.borrowedAt=borrowedAt;
        this.dueDate=dueDate;
        this.returnedAt=returnedAt;
    }
}

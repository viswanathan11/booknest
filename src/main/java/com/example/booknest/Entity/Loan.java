package com.example.booknest.Entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity 
@Table (name = "loans")
@NoArgsConstructor 
@Getter 
@Setter 
public class Loan {
    @Id 
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name="id")
    private Long loanId;

    @ManyToOne
    @JoinColumn (name="member_id",nullable = false)
    private Member member;

    @ManyToOne 
    @JoinColumn (name="book_id",nullable =false)
    private Book book;

    @Column (name="borrowed_at",nullable = false)
    private LocalDate borrowedAt;
    @Column (name="due_date",nullable = false)
    private LocalDate dueDate;
    @Column (name="returned_at")
    private LocalDate returnedAt;

    @Enumerated (EnumType.STRING)
    @Column (name = "status",nullable = false)
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

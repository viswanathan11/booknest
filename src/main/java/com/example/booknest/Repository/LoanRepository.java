package com.example.booknest.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.booknest.Entity.Loan;

public interface LoanRepository extends JpaRepository<Loan,Long> {
    
}

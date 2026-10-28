package com.example.booknest.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.booknest.Entity.Loan;
import com.example.booknest.Entity.LoanStatus;

public interface LoanRepository extends JpaRepository<Loan,Long> {
    long countByMemberIdAndLoanStatus(Long memberId,LoanStatus loanStatus);
}

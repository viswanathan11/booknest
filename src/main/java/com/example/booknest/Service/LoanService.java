package com.example.booknest.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.booknest.Repository.LoanRepository;

@Service 
public class LoanService {
    @Autowired 
    LoanRepository loanRepository;
}

package com.example.booknest.dto.response;

import com.example.booknest.Entity.LoanStatus;

public record LoanResponse(
    Long id,
    BookResponse book,
    MemberResponse member,
    LoanStatus status
) {
}
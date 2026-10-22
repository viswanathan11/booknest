package com.example.booknest.dto.response;

import com.example.booknest.Entity.LoanStatus;

public record LoanResponse(
    Long id,
    Long bookId,
    Long memberId,
    LoanStatus status
) {
}
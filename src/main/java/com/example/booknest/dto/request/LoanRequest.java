package com.example.booknest.dto.request;

/**
 * LoanRequest
 */
public record LoanRequest(
    Long bookId,
    Long memberId
) {
}

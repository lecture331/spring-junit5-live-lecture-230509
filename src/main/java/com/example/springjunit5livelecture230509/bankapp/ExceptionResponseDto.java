package com.example.springjunit5livelecture230509.bankapp;

import lombok.Getter;

@Getter
public class ExceptionResponseDto {
    String message;
    int statsCode;

    public ExceptionResponseDto(String message, int statsCode) {
        this.message = message;
        this.statsCode = statsCode;
    }
}

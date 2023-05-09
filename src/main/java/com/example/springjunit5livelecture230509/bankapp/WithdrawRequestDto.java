package com.example.springjunit5livelecture230509.bankapp;

import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class WithdrawRequestDto {
    @Size(min=3, max=10)
    private String account;
    @Size(min=3, max=6)
    private String password;
    @Positive(message = "1 이상의 숫자만 입력 가능합니다.")
    private double cash;
}

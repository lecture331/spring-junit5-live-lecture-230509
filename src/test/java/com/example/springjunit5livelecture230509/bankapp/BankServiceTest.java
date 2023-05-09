package com.example.springjunit5livelecture230509.bankapp;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class) // Mockito를 사용함을 명시적으로 알립니다.
class BankServiceTest {
    @Mock
    BankRepository bankRepository;

    @Test
    @DisplayName("계좌 출금 withdrawFromAccount 메서드 테스트")
    void test1(){
        // given
        WithdrawRequestDto requestDto = new WithdrawRequestDto("111-111", "1111", 8000);
        BankService bankService = new BankService(bankRepository);
        when(bankRepository.getAccount(requestDto.getAccount())).thenReturn(new Account("111-111", "1111", 10000));

        // when
        Account account = bankService.withdrawFromAccount(requestDto);

        // then
        assertEquals(2000, account.getCash());
    }
}
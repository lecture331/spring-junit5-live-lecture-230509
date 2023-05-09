package com.example.springjunit5livelecture230509.bankapp;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class BankServiceSpringTest {

    @Autowired
    BankService bankService;

//    @Autowired
    @MockBean
    BankRepository bankRepository;

    @Test
    @DisplayName("BankService 계좌 출금 API SpringBoot 환경에서 테스트")
    void test1(){
        // given
        WithdrawRequestDto requestDto = new WithdrawRequestDto("123-456", "1234", 80000);

        // when
        Account account = bankService.withdrawFromAccount(requestDto);

        // then
        assertEquals(20000, account.getCash());
        assertEquals(20000, bankRepository.getAccount(account.getAccount()).getCash()); // 실제 값에 대한 확인
    }

    @Test
    @DisplayName("BankService 계좌 출금 API SpringBoot 환경에서 테스트 : Mockito")
    void test2(){
        // given
        WithdrawRequestDto requestDto = new WithdrawRequestDto("111-111", "1111", 8000);
        BankService bankService = new BankService(bankRepository);
        given(bankRepository.getAccount(requestDto.getAccount())).willReturn(new Account("111-111", "1111", 10000));

        // when
        Account account = bankService.withdrawFromAccount(requestDto);

        // then
        assertEquals(2000, account.getCash());
    }
}
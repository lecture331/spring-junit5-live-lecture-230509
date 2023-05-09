package com.example.springjunit5livelecture230509.bankapp;

import org.springframework.stereotype.Service;

@Service
public class BankService {

    private final BankRepository bankRepository;

    public BankService(BankRepository bankRepository) {
        this.bankRepository = bankRepository;
    }

    public Account withdrawFromAccount(WithdrawRequestDto requestDto) {
        Account account = bankRepository.getAccount(requestDto.getAccount());
        if(checkPassword(account.getPassword(), requestDto.getPassword())) {
            account.setCash(account.getCash() - requestDto.getCash());
            return account;
        } else {
            throw new IllegalArgumentException("잘못된 비밀번호입니다.");
        }
    }

    private boolean checkPassword(String bankAccount, String requestAccount) {
        return bankAccount.equals(requestAccount);
    }

}

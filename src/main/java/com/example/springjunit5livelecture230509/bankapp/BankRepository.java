package com.example.springjunit5livelecture230509.bankapp;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class BankRepository {
    public static final Map<String, Account> BANK = new HashMap<>();
    public Account getAccount(String account) {
        for (String ac : BANK.keySet()) {
            if(ac.equals(account)) {
                return BANK.get(ac);
            }
        }
        throw new IllegalArgumentException("없는 계좌입니다.");
    }
}

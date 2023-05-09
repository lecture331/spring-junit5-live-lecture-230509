package com.example.springjunit5livelecture230509.bankapp;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class TestRunner implements ApplicationRunner {
    @Override
    public void run(ApplicationArguments args) throws Exception {
        BankRepository.BANK.put("123-456", new Account("123-456", "1234", 100_000));
        BankRepository.BANK.put("654-321", new Account("654-321", "4321", 100_000_000));
    }
}

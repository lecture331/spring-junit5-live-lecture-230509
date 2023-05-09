package com.example.springjunit5livelecture230509.bankapp;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Account {
    private String account;
    private String password;
    private double cash;

    public Account(String account, String password, double cash) {
        this.account = account;
        this.password = password;
        this.cash = cash;
    }
}

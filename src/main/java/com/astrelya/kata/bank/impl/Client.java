package com.astrelya.kata.bank.impl;

import com.astrelya.kata.bank.IClient;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.regex.Pattern;

public class Client implements IClient {

    private final String email;

    public Client(String email) {
        String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        Pattern pattern = Pattern.compile(EMAIL_REGEX);
        if(!pattern.matcher(email).matches())
            throw new IllegalArgumentException("client1 is not a valid email");
        this.email = email;
    }

    @Override
    public String getEmail() {
        return this.email;
    }

    @Override
    public Collection<Object> getProductList() {
        return null;
    }

    @Override
    public BigDecimal getMonthlyBalance() {
        return null;
    }

    @Override
    public void addProduct(String productType, Double amount) {

    }
}

package com.astrelya.kata.bank.impl;

import com.astrelya.kata.bank.IProduct;
import com.astrelya.kata.bank.ProductType;

import java.math.BigDecimal;


public class Pret implements IProduct {

    private final ProductType productType;
    private final Double rate;
    private final Double amount;

    public Pret(Double amount) {
        this.amount = amount;
        this.productType = ProductType.PRET;
        this.rate = 2d;
    }

    public Double getAmount() {
        return amount;
    }

    public Double getRate() {
        return rate;
    }

    public BigDecimal getMonthlyValue() {
        return BigDecimal.valueOf(-(this.amount * (this.rate / 100)) / 12);
    }

    public ProductType getProductType() {
        return productType;
    }
}

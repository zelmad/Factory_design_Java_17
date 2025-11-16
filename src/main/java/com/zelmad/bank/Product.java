package com.zelmad.bank;

import java.math.BigDecimal;

public abstract class Product {

    private final Double rate;
    private final Double amount;

    protected Product(Double rate, Double amount){
        this.amount = amount;
        this.rate = rate;
    }

    public BigDecimal getMonthlyValue() {
        return BigDecimal.valueOf((this.amount * (this.rate / 100))/12);
    }

    public abstract ProductType getProductType();
}

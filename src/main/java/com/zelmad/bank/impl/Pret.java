package com.zelmad.bank.impl;

import com.zelmad.bank.Product;
import com.zelmad.bank.ProductType;

public class Pret extends Product {

    public static final double RATE = 2d;
    private final ProductType productType;

    public Pret(Double amount) {
        super(RATE, amount);
        this.productType = ProductType.PRET;
    }

    public ProductType getProductType() {
        return productType;
    }
}

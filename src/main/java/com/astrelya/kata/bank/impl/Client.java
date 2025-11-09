package com.astrelya.kata.bank.impl;

import com.astrelya.kata.bank.IClient;
import com.astrelya.kata.bank.IProduct;
import com.astrelya.kata.bank.IProductFactory;

import java.math.BigDecimal;
import java.util.*;
import java.util.regex.Pattern;

public class Client implements IClient {

    private final String email;

    private List<IProduct> products;

    public Client(String email) {
        String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        Pattern pattern = Pattern.compile(EMAIL_REGEX);
        if (!pattern.matcher(email).matches()) throw new IllegalArgumentException("client1 is not a valid email");
        this.email = email;
        this.products = new ArrayList<>();
    }

    @Override
    public String getEmail() {
        return this.email;
    }

    @Override
    public Collection<Object> getProductList() {
        return Collections.singleton(this.products);
    }

    @Override
    public BigDecimal getMonthlyBalance() {
        BigDecimal result = BigDecimal.ZERO;
        for (IProduct product : this.products) {
            switch (product.getProductType()) {
                case LDD -> {
                    LDD ldd = (LDD) product;
                    result = result.add(ldd.getMonthlyValue());
                }
                case COMPTEAVUE -> {
                    CompteAVue compteAVue = (CompteAVue) product;
                    result = result.add(compteAVue.getMonthlyValue());
                }
                case LIVRETA -> {
                    LivretA la = (LivretA) product;
                    result = result.add(la.getMonthlyValue());
                }
            }
        }
        return result;
    }

    @Override
    public void addProduct(String productType, Double amount) {
        IProductFactory iProductFactory = new IProductFactory();
        if (products.stream().anyMatch(prd -> productType.equalsIgnoreCase(prd.getProductType().toString()))) {
            throw new IllegalArgumentException(this.email + " cannot have two " + productType);
        }
        products.add(iProductFactory.createProduct(productType, amount));
    }
}

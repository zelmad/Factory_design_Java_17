package com.astrelya.kata.bank.impl;

import com.astrelya.kata.bank.IClient;
import com.astrelya.kata.bank.IProduct;
import com.astrelya.kata.bank.IProductFactory;
import com.astrelya.kata.bank.ProductType;

import java.math.BigDecimal;
import java.util.*;
import java.util.regex.Pattern;

public class Client implements IClient {

    private final String email;

    private List<IProduct> products;

    public Client(String email) {
        String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        Pattern pattern = Pattern.compile(EMAIL_REGEX);
        if(!pattern.matcher(email).matches())
            throw new IllegalArgumentException("client1 is not a valid email");
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
        BigDecimal result = null;
        this.products.stream().forEach(product -> {
            switch (product.getProductType()) {
                case LDD:
                    LDD ldd = (LDD) product;
                    result.add(new BigDecimal((ldd.getAmount() * (ldd.getRate() / 100))/12));
                    break;
                case COMPTEAVUE:
                    CompteAVue compteAVue = (CompteAVue) product;
                    result.add(new BigDecimal((compteAVue.getAmount() * (compteAVue.getRate() / 100))/12));
                    break;
                case LIVRETA:
                    LivretA la = (LivretA) product;
                    result.add(new BigDecimal((la.getAmount() * (la.getRate() / 100))/12));
                    break;
            }
        });
        return result;
    }

    @Override
    public void addProduct(String productType, Double amount) {
        IProductFactory iProductFactory = new IProductFactory();
        if(products.stream()
                .anyMatch(prd -> Objects.equals(productType, prd.getProductType().toString()))
        ) {
            throw new IllegalArgumentException(this.email + " cannot have two " + productType);
        }
        products.add(iProductFactory.createProduct(productType, amount));
    }
}

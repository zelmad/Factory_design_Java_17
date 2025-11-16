package com.zelmad.bank.impl;

import com.zelmad.bank.Client;
import com.zelmad.bank.Product;
import com.zelmad.bank.ProductFactory;
import com.zelmad.bank.ProductType;

import java.math.BigDecimal;
import java.util.*;
import java.util.regex.Pattern;

public class ClientImpl implements Client {

    private final String email;

    private final List<Product> products;

    public ClientImpl(String email) {
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
    public List<Product> getProductList() {
        return this.products;
    }

    @Override
    public BigDecimal getMonthlyBalance() {
        BigDecimal result = BigDecimal.ZERO;
        for (Product product : this.products) {
            if(product instanceof Pret pret) {
                result = result.subtract(pret.getMonthlyValue());
            } else {
                result = result.add(product.getMonthlyValue());
            }
        }
        return result;
    }

    @Override
    public void addProduct(String productType, Double amount) {
        ProductFactory productFactory = new ProductFactory();
        boolean checkAccountExistence = products.stream()
                .anyMatch(prd -> productType.equals(prd.getProductType().getValue()));
        if (checkAccountExistence) {
            throw new IllegalArgumentException(this.email + " cannot have two " + productType);
        }
        products.add(productFactory.createProduct(ProductType.typeFromValue(productType), amount));

    }
}

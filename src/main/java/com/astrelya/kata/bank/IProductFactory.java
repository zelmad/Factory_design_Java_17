package com.astrelya.kata.bank;

import com.astrelya.kata.bank.impl.CompteAVue;
import com.astrelya.kata.bank.impl.LDD;
import com.astrelya.kata.bank.impl.LivretA;
import com.astrelya.kata.bank.impl.Pret;

public class IProductFactory {

    public IProduct createProduct(String productType, Double amount) {
        return switch (productType) {
            case "LivretA" -> new LivretA(amount);
            case "LDD" -> new LDD(amount);
            case "CompteAVue" -> new CompteAVue(amount);
            default -> new Pret(amount);
        };
    }
}

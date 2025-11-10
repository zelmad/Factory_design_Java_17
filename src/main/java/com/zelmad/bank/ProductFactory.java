package com.zelmad.bank;

import com.zelmad.bank.impl.CompteAVue;
import com.zelmad.bank.impl.LDD;
import com.zelmad.bank.impl.LivretA;
import com.zelmad.bank.impl.Pret;

public class ProductFactory {

    public Product createProduct(String productType, Double amount) {
        return switch (productType) {
            case "LivretA" -> new LivretA(amount);
            case "LDD" -> new LDD(amount);
            case "CompteAVue" -> new CompteAVue(amount);
            case "Pret" -> new Pret(amount);
            default -> throw new IllegalArgumentException("unknown bank account");
        };
    }
}

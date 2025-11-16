package com.zelmad.bank;

import com.zelmad.bank.impl.CompteAVue;
import com.zelmad.bank.impl.LDD;
import com.zelmad.bank.impl.LivretA;
import com.zelmad.bank.impl.Pret;

public class ProductFactory {

    public Product createProduct(ProductType productType, Double amount) {
        return switch (productType) {
            case LIVRETA -> new LivretA(amount);
            case LDD -> new LDD(amount);
            case COMPTEAVUE -> new CompteAVue(amount);
            case PRET -> new Pret(amount);
        };
    }
}

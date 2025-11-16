package com.zelmad.bank;

public enum ProductType {
    LDD("LDD"), PRET("Pret"), LIVRETA("LivretA"), COMPTEAVUE("CompteAVue");

    private final String value;

    ProductType(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}

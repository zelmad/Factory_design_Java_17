package com.zelmad.bank;

import java.util.Arrays;

public enum ProductType {
    LDD("LDD"), PRET("Pret"), LIVRETA("LivretA"), COMPTEAVUE("CompteAVue");

    private final String value;

    ProductType(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }

    public static ProductType typeFromValue(String value) {
        return Arrays.stream(ProductType.values())
                .filter(productType -> value.equals(productType.getValue()))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Unknown account type : " + value));
    }
}

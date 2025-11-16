package com.zelmad.bank.impl;

import com.zelmad.bank.Product;
import com.zelmad.bank.ProductType;

public class CompteAVue extends Product {

	public static final double RATE = 0.5;
	private final ProductType productType;
	
	public CompteAVue(Double amount) {
		super(RATE, amount);
		this.productType = ProductType.COMPTEAVUE;
	}

	public ProductType getProductType() {
		return productType;
	}
}

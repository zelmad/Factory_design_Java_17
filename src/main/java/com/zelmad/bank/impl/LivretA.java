package com.zelmad.bank.impl;

import com.zelmad.bank.Product;
import com.zelmad.bank.ProductType;


public class LivretA extends Product {

	public static final double RATE = 0.75;
	private final ProductType productType;
	
	public LivretA(Double amount) {
		super(RATE, amount);
		this.productType = ProductType.LIVRETA;

	}

	public ProductType getProductType() {
		return productType;
	}
}

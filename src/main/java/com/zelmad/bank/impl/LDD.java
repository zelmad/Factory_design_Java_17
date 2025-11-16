package com.zelmad.bank.impl;

import com.zelmad.bank.Product;
import com.zelmad.bank.ProductType;


public class LDD extends Product {

	public static final double RATE = 1d;
	private final ProductType productType;

	
	public LDD(Double amount) {
		super(RATE, amount);
		this.productType = ProductType.LDD;
	}

	public ProductType getProductType() {
		return productType;
	}
}

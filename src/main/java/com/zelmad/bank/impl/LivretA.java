package com.zelmad.bank.impl;

import java.math.BigDecimal;

import com.zelmad.bank.Product;
import com.zelmad.bank.ProductType;


public class LivretA implements Product {

	private final ProductType productType;
	private Double rate;
	private final Double amount;
	
	public LivretA(Double amount) {
		this.amount = amount;
		this.productType = ProductType.LIVRETA;
		this.rate = 0.75;
	}
	
	public Double getAmount() {
		return amount;
	}
	
	public Double getRate() {
		return rate;
	}
	
	public BigDecimal getMonthlyValue() {
		return BigDecimal.valueOf((this.amount * (this.rate / 100))/12);
	}

	public ProductType getProductType() {
		return productType;
	}
}

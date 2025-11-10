package com.zelmad.bank.impl;

import java.math.BigDecimal;

import com.zelmad.bank.Product;
import com.zelmad.bank.ProductType;


public class LDD implements Product {

	private final ProductType productType;
	private final Double rate;
	private final Double amount;
	
	public LDD(Double amount) {
		this.amount = amount;
		this.productType = ProductType.LDD;
		this.rate = 1d;
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

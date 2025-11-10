package com.zelmad.bank.impl;

import java.math.BigDecimal;

import com.zelmad.bank.Product;
import com.zelmad.bank.ProductType;

public class CompteAVue implements Product {

	private final ProductType productType;
	private Double rate;
	private Double amount;
	
	public CompteAVue(Double amount) {
		this.amount = amount;
		this.productType = ProductType.COMPTEAVUE;
		this.rate = 0.5;
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

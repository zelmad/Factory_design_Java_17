package com.astrelya.kata.bank.impl;

import java.math.BigDecimal;

import com.astrelya.kata.bank.IProduct;
import com.astrelya.kata.bank.ProductType;
import org.apache.commons.lang3.NotImplementedException;



public class LivretA implements IProduct {

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

package com.astrelya.kata.bank.impl;

import java.math.BigDecimal;

import com.astrelya.kata.bank.IProduct;
import com.astrelya.kata.bank.ProductType;
import org.apache.commons.lang3.NotImplementedException;


public class LDD implements IProduct {

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

package com.astrelya.kata.bank.impl;

import java.math.BigDecimal;

import com.astrelya.kata.bank.IProduct;
import com.astrelya.kata.bank.ProductType;
import org.apache.commons.lang3.NotImplementedException;



public class LivretA implements IProduct {

	private final ProductType productType;
	private Double rate;
	private Double amount;
	
	public LivretA(Double amount) {
		this.amount = amount;
		this.productType = ProductType.LIVRETA;
	}
	
	public Double getAmount() {
		return amount;
	}
	
	public Double getRate() {
		return rate;
	}
	
	public BigDecimal getMonthlyValue() {
		throw new NotImplementedException();
	}

	public ProductType getProductType() {
		return productType;
	}
}

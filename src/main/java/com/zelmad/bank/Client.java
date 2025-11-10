package com.zelmad.bank;

import java.math.BigDecimal;
import java.util.Collection;

public interface Client {

	public String getEmail();
	
	public Collection<Object> getProductList();
	
	public BigDecimal getMonthlyBalance();
	
	public void addProduct(String productType,Double amount);
}

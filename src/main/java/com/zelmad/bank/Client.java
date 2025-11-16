package com.zelmad.bank;

import java.math.BigDecimal;
import java.util.List;

public interface Client {

	public String getEmail();
	
	public List<Product> getProductList();
	
	public BigDecimal getMonthlyBalance();
	
	public void addProduct(String productType,Double amount);
}

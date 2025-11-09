package com.astrelya.kata.bank;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Optional;

public interface IBank {

	public Collection<IClient> getClientList();
	
	public void addClient(IClient client);
	
	public Optional<IClient> searchClient(String email);
	
	public BigDecimal getMonthlyPNL();
}

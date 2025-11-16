package com.zelmad.bank;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface Bank {

    public List<Client> getClientList();

    public void addClient(Client client);

    public Optional<Client> searchClient(String email);

    public BigDecimal getMonthlyPNL();
}

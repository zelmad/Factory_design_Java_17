package com.zelmad.bank.impl;

import com.zelmad.bank.Bank;
import com.zelmad.bank.Client;

import java.math.BigDecimal;
import java.util.*;

public class BankImpl implements Bank {

    private final List<Client> clients;

    public BankImpl() {
        this.clients = new ArrayList<>();
    }

    @Override
    public Collection<Client> getClientList() {
        return this.clients;
    }

    @Override
    public void addClient(Client client) {
        if (clients.stream().anyMatch(clt -> Objects.equals(client.getEmail(), clt.getEmail()))) {
            throw new IllegalArgumentException("Client " + client.getEmail() + " already exist");
        }
        clients.add(client);
    }

    @Override
    public Optional<Client> searchClient(String email) {
        return clients.stream()
                .filter(clt -> Objects.equals(email, clt.getEmail()))
                .findFirst();
    }

    @Override
    public BigDecimal getMonthlyPNL() {
        BigDecimal monthlyNpl = BigDecimal.ZERO;
        if(clients.isEmpty())
            return monthlyNpl;
        for(Client client : clients) {
            BigDecimal clientMonthlyBalance = client.getMonthlyBalance();
            if(clientMonthlyBalance.compareTo(BigDecimal.ZERO) > 0) {
                monthlyNpl = monthlyNpl.subtract(clientMonthlyBalance);
            } else {
                monthlyNpl = monthlyNpl.add(clientMonthlyBalance.abs());
            }
        }
        return monthlyNpl;
    }
}

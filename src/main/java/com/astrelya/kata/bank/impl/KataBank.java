package com.astrelya.kata.bank.impl;

import com.astrelya.kata.bank.IBank;
import com.astrelya.kata.bank.IClient;

import java.math.BigDecimal;
import java.util.*;

public class KataBank implements IBank {

    private final List<IClient> clients;

    public KataBank() {
        this.clients = new ArrayList<>();
    }

    @Override
    public Collection<IClient> getClientList() {
        return this.clients;
    }

    @Override
    public void addClient(IClient client) {
        if (clients.stream().anyMatch(clt -> Objects.equals(client.getEmail(), clt.getEmail()))) {
            throw new IllegalArgumentException("Client " + client.getEmail() + " already exist");
        }
        clients.add(client);
    }

    @Override
    public Optional<IClient> searchClient(String email) {
        return clients.stream()
                .filter(clt -> Objects.equals(email, clt.getEmail()))
                .findFirst();
    }

    @Override
    public BigDecimal getMonthlyPNL() {
        return null;
    }
}

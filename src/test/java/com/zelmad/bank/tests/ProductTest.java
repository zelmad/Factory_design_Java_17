package com.zelmad.bank.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.math.BigDecimal;
import java.util.Optional;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.zelmad.bank.Bank;
import com.zelmad.bank.Client;
import com.zelmad.bank.impl.ClientImpl;
import com.zelmad.bank.impl.BankImpl;

public class ProductTest {
	
	Bank bank;
	
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	@Before
	public void setUp() {
		bank = new BankImpl();
		bank.addClient(new ClientImpl("client1@test.com"));
		bank.addClient(new ClientImpl("client2@test.com"));
		bank.addClient(new ClientImpl("client3@test.com"));
	}

	@Test
	public void if_1000_on_livretA_cost_0_625() {
		Optional<Client> clientOpt = bank.searchClient("client1@test.com");
		
		if(clientOpt.isEmpty()) {
			fail("client1@test.com should exist");
		}
		
		Client client = clientOpt.get();
		client.addProduct("LivretA",1000.0);
		assertEquals(0, BigDecimal.valueOf(0.625).compareTo(client.getMonthlyBalance()));
		
	}
	
	@Test
	public void if_2100_on_LDD_cost_1_75() {
		Optional<Client> clientOpt = bank.searchClient("client2@test.com");
		
		if(clientOpt.isEmpty()) {
			fail("client2@test.com should exist");
		}
		
		Client client = clientOpt.get();
		client.addProduct("LDD",2100.0);
		assertEquals(0,BigDecimal.valueOf(1.75).compareTo(client.getMonthlyBalance()));
		
	}
	
	@Test
	public void if_3000_on_CompteAVue_cost_1_25() {
		Optional<Client> clientOpt = bank.searchClient("client3@test.com");
		
		if(clientOpt.isEmpty()) {
			fail("client3@test.com should exist");
		}
		
		Client client = clientOpt.get();
		client.addProduct("CompteAVue",3000.0);
		assertEquals(0,BigDecimal.valueOf(1.25).compareTo(client.getMonthlyBalance()));
		
	}
	
	@Test
	public void client_cannot_have_2_LDD() {
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("client1@test.com cannot have two LDD");
		Optional<Client> clientOpt = bank.searchClient("client1@test.com");
		
		if(clientOpt.isEmpty()) {
			fail("client1@test.com should exist");
		}
		
		Client client = clientOpt.get();
		client.addProduct("LDD",3000.0);
		client.addProduct("LDD",5000.0);
		
	}
	
	@Test
	public void client_cannot_have_2_LivretA() {
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("client1@test.com cannot have two LivretA");
		Optional<Client> clientOpt = bank.searchClient("client1@test.com");
		
		if(clientOpt.isEmpty()) {
			fail("client1@test.com should exist");
		}
		
		Client client = clientOpt.get();
		client.addProduct("LivretA",3000.0);
		client.addProduct("LivretA",6000.0);
		
	}
	
	@Test
	public void client_cannot_have_2_CAV() {
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("client1@test.com cannot have two CompteAVue");
		Optional<Client> clientOpt = bank.searchClient("client1@test.com");
		
		if(clientOpt.isEmpty()) {
			fail("client1@test.com should exist");
		}
		
		Client client = clientOpt.get();
		client.addProduct("CompteAVue",3000.0);
		client.addProduct("CompteAVue",1000.0);
		
	}

	@Test
	public void if_we_lend_15000_we_get_minus_25() {
		Optional<Client> clientOpt = bank.searchClient("client1@test.com");

		if(clientOpt.isEmpty()) {
			fail("client1@test.com should exist");
		}

		Client client = clientOpt.get();
		client.addProduct("Pret",15000.0);
		assertEquals(0,BigDecimal.valueOf(-25.0).compareTo(client.getMonthlyBalance()));

	}

	@Test
	public void monthly_should_be() {
		Optional<Client> clientOpt = bank.searchClient("client2@test.com");

		if(clientOpt.isEmpty()) {
			fail("client2@test.com should exist");
		}

		Client client2 = clientOpt.get();
		clientOpt = bank.searchClient("client1@test.com");

		if(clientOpt.isEmpty()) {
			fail("client1@test.com should exist");
		}

		Client client1 = clientOpt.get();
		clientOpt = bank.searchClient("client3@test.com");

		if(clientOpt.isEmpty()) {
			fail("client3@test.com should exist");
		}

		Client client3 = clientOpt.get();

		client1.addProduct("LivretA",1000.0);
		client1.addProduct("Pret",42000.0);

		assertEquals(0,BigDecimal.valueOf(-69.375).compareTo(client1.getMonthlyBalance()));

		client2.addProduct("LivretA",1000.0);
		client2.addProduct("LDD",2100.0);
		client2.addProduct("CompteAVue",6000.0);

		assertEquals(0,BigDecimal.valueOf(4.875).compareTo(client2.getMonthlyBalance()));

		client3.addProduct("LivretA",2400.0);
		client3.addProduct("LDD",9000.0);
		client3.addProduct("CompteAVue",3000.0);
		client3.addProduct("Pret",12000.0);

		assertEquals(0,BigDecimal.valueOf(-9.75).compareTo(client3.getMonthlyBalance()));

		assertEquals(0,BigDecimal.valueOf(74.25).compareTo(bank.getMonthlyPNL()));

	}

}
package com.rest.bank;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.time.LocalDate;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

import com.rest.bank.model.Bank;
import com.rest.bank.service.BankService;



@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.NONE)
public class Service {
	
	@Autowired
	private BankService bankservice;
	
	
	@Test
	public void testAddBank() {
		
		// add a bank
		Bank bank = new Bank();
		bank.setBankid(10080);
		bank.setBankname("TEST BANK");
		bank.setBankaddress("TEST ADDRESS");
		bank.setCardcount((short) 20);
		
		
		//Test adding a bank
		Bank newbank = bankservice.addBank(bank);
		
		
		//Verify the results
		assertNotNull(newbank);
		assertNotNull(newbank.getBankid());
		assertEquals("TEST ADDRESS",newbank.getBankaddress());
		
	}

}


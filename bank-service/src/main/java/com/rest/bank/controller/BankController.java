package com.rest.bank.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rest.bank.model.Bank;
import com.rest.bank.service.BankService;


@RestController
public class BankController {
	@Autowired
	private BankService banksService;

	@RequestMapping("/banks")
	public List<Bank> getAllBanks()
	{
		return banksService.getAllBanks();
	}
	
	@RequestMapping(method = RequestMethod.POST, value="/bank")
	public void addBank(@RequestBody Bank bank)
	{
		banksService.addBank(bank);
	}
	
	@RequestMapping(method = RequestMethod.GET, value="/bank/{bankid}")
	public  Optional<Bank> findById(@PathVariable Long bankid)
	{
		return banksService.findById(bankid);
		
	}
	
	@RequestMapping(method = RequestMethod.PUT, value="/bank/cardcount/{bankid}")
	public void updatecardcount(@PathVariable Long bankid)
	{
			banksService.updatecardcount(bankid);
	}
	
	
/*	@RequestMapping(method = RequestMethod.GET, value="/bank/cardcount/{bankid}")
	public  List<Object> getcardcount(@PathVariable Long bankid)
	{
		return banksService.getcardcount(bankid);
		
	}
*/
	
			
}
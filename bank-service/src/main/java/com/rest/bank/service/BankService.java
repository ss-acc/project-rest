package com.rest.bank.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.bank.model.Bank;
import com.rest.bank.repo.BankRepository;



@Service
public class BankService {
	@Autowired
	public BankRepository bankRepo;

	public List<Bank> getAllBanks()
	{
		List<Bank> banks = new ArrayList<>();
		bankRepo.findAll().forEach(banks::add);
		return banks;
	}

	public void addBank(Bank bank) {
		bankRepo.save(bank);
		
	}
	
	
	public Optional<Bank> findById(Long bankid) {

        return bankRepo.findById(bankid);
	}	
	
	
	public void updatecardcount(Long bankid) {
		bankRepo.updatecardcount(bankid);
		
	}
	
	
	
/*	public List<Object> getcardcount(Long bankid) {
	    return bankRepo.getcardcount(bankid);
	  	}
*/	
	
	
	
	
	
	
}
package com.rest.card.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.rest.card.Senderqueue;
import com.rest.card.model.Card;
import com.rest.card.service.CardService;

@RestController
public class CardController {
	@Autowired
	private CardService cardsService;

	@RequestMapping("/cards")
	public List<Card> getAllCards()
	{
		return cardsService.getAllCards();
	}
	
	@RequestMapping(method = RequestMethod.POST, value="/card")
	public void addCard(@RequestBody Card card)
	{
		cardsService.addCard(card);
		
		updatecardcount(card.bankid);
		
		send();
		
	 	}
	
	public void updatecardcount(long bankid){
	
	String uri = "http://localhost:8062/bank/cardcount/{bankid}";
	RestTemplate restTemplate = new RestTemplate();
	restTemplate.put(uri,null,bankid);
	
 }
	
	 @Autowired
	    private Senderqueue senderqueue;
	
	
	 public void send(){
	        senderqueue.send("New Card issued");
	
	 }	
	
	
	
	
	
/*	public short getcardcount(short bankid){
		
		String uri = "http://localhost:8062/bank/cardcount/{bankid}";
		RestTemplate restTemplate = new RestTemplate();
		short result = restTemplate.getForObject(uri, short.class, bankid);
		return result;
	}
*/	
//	private void addcardcount(long bankid,short result) {
//
//		String uri = "http://localhost:8062/bank/{bankid}";
//		RestTemplate restTemplate = new RestTemplate();
//		restTemplate.patchForObject(uri,
//		
//	}
	
	
}
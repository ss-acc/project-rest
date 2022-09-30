package com.rest.card.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolationException;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.support.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
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
	public Card addCard(@RequestBody @Valid Card card) throws MethodArgumentNotValidException
	{
		cardsService.addCard(card);
			
		
		updatecardcount(card.bankid);
		
		send();
		
		return card;
		
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
	

	 
	/* @ExceptionHandler(MethodArgumentNotValidException.class)
	  @ResponseStatus(HttpStatus.BAD_REQUEST)
	 public String constraintviolationHandler(
		        HttpServletRequest request, HttpServletResponse response, Exception ex) {
		     
		    // code that handles exception 
		     
		    return ex.getMessage();
		}*/
	//  ResponseEntity<String> handleConstraintViolationException(ConstraintViolationException e) {
	 //   return new ResponseEntity<>("not valid due to validation error: " + e.getMessage(), HttpStatus.BAD_REQUEST);
	 // }
	 
	 
	
	
	
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
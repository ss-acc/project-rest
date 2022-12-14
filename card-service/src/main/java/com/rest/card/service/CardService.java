package com.rest.card.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.card.exception.NoDataFoundException;
import com.rest.card.model.Card;
import com.rest.card.repo.CardRepository;


@Service
public class CardService {
	@Autowired
	public CardRepository cardRepo;

	public List<Card> getAllCards()
	{
		List<Card> cards = new ArrayList<>();
		cardRepo.findAll().forEach(cards::add);
        if (cards.isEmpty()) {

            throw new NoDataFoundException();
        }		
		
		
		return cards;
	}

	public Card addCard(Card card) {
		cardRepo.save(card);
		
		return card;
		
	}


}



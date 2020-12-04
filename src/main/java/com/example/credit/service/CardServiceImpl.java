package com.example.credit.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.credit.card.Card;
import com.example.credit.repository.CardRepository;

@Service
public class CardServiceImpl implements CardService{

	@Autowired
	CardRepository cardRepository;
	
	@Override
	public List<Card> findAllCards() {
		return cardRepository.findAll();
	}

	@Override
	public Card addCard(Card card) {
		return cardRepository.saveAndFlush(card);
	}

	@Override
	public Optional<Card> findById(long id) {
		return cardRepository.findById(id);
	}

}
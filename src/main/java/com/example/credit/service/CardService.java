package com.example.credit.service;

import java.util.List;
import java.util.Optional;

import com.example.credit.card.Card;

public interface CardService {
	public List<Card> findAllCards();
    public Card addCard(Card card);
	public Optional<Card> findById(long id);
}

package co.uk.credit.card.service;

import java.util.List;

import co.uk.credit.card.model.Card;

public interface CardService {
	public List<Card> findAllCards();
    public Card addCard(Card card);
}

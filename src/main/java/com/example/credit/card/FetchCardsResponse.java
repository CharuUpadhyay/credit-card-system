package com.example.credit.card;

import java.util.List;

public class FetchCardsResponse extends Response{
	private List<Card> cards;

	public List<Card> getCards() {
		return cards;
	}

	public void setCards(List<Card> cards) {
		this.cards = cards;
	}
	
}

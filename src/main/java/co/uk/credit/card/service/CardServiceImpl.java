package co.uk.credit.card.service;

import java.math.BigDecimal;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.uk.credit.card.Utility;
import co.uk.credit.card.exception.InvalidCardNumberException;
import co.uk.credit.card.model.Card;
import co.uk.credit.card.repository.CardRepository;

/**
 * @author charu
 *
 */
@Service
public class CardServiceImpl implements CardService{
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	CardRepository cardRepository;
	
	@Override
	public List<Card> findAllCards() {
		try {
			logger.debug("Fetching existing cards.");
			return cardRepository.findAll();
		}catch(Exception e) {
			logger.error("Exception occurred while fetching card detail - " + e);
		}
		return null;
	}

	@Override
	public Card addCard(Card card) {
		try {
			logger.debug("Adding new card");
			if(Utility.isValidCard(card.getNumber())) {
				card.setBalance(new BigDecimal(0));
				return cardRepository.saveAndFlush(card);
			}
		}catch(Exception e) {
			logger.error("Exception occurred while fetching card detail - " + e);
		}
		
		throw new InvalidCardNumberException("Entered card number is invalid!!");
	}

}

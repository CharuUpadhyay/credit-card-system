package com.example.credit.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.credit.card.Card;
import com.example.credit.repository.CardRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class CardServiceImplTest {
	
	@Autowired
	CardService service;
	
	@MockBean
	private CardRepository cardRepository;
	
	private Card card;
	private List<Card> cardList = new ArrayList<>();	

	@Before
	public void setUp() throws Exception {
		card = new Card(10004L, "test", "1111222233334444", BigDecimal.valueOf(4.0), BigDecimal.valueOf(4.0));
		cardList.add(card);
	}

	@Test
	public void testFindAllCards() {
		when(cardRepository.findAll()).thenReturn(cardList);
		List<Card> result = service.findAllCards();
		assertNotNull(result);
		assertEquals("Result size incorrect", 1, result.size());
	}
	
	@Test
	public void testAddCard() {
		when(cardRepository.saveAndFlush(Mockito.any(Card.class))).thenReturn(card);
		Card result = service.addCard(card);
		assertNotNull(result);
	}

}

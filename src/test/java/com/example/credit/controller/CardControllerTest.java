package com.example.credit.controller;

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
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.example.credit.card.Card;
import com.example.credit.service.CardService;
import com.fasterxml.jackson.databind.ObjectMapper;

@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
@SpringBootTest
public class CardControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private CardService cardService;
	

	private Card card;
	private List<Card> cardList = new ArrayList<>();

	private String baseUrl = "/cards";
	
	@Before
	public void setUp() throws Exception {
		card = new Card(10004L, "test", "4444", BigDecimal.valueOf(4.0), BigDecimal.valueOf(4.0));
		cardList.add(card);
	}
	
	@Test
	public void testFindCards() throws Exception {
		when(cardService.findAllCards()).thenReturn(cardList);
		MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get(baseUrl)
				.accept(MediaType.APPLICATION_JSON).contentType(org.springframework.http.MediaType.APPLICATION_JSON)).andReturn();

		assertNotNull("Cards not Found", result.getResponse().getContentAsString());
	}

	@Test
	public void testAddCard() throws Exception {
		when(cardService.addCard(Mockito.any(Card.class))).thenReturn(card);
		MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post(baseUrl).content(asJsonString(card))
				.accept(MediaType.APPLICATION_JSON).contentType(org.springframework.http.MediaType.APPLICATION_JSON)).andReturn();

		assertNotNull("Card not added", result.getResponse().getContentAsString());
	}
	
	public static String asJsonString(final Object obj) {
	    try {
	        return new ObjectMapper().writeValueAsString(obj);
	    } catch (Exception e) {
	        throw new RuntimeException(e);
	    }
	}
}

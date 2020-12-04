package com.example.credit.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.credit.card.Card;
import com.example.credit.exception.CardNotFoundException;
import com.example.credit.service.CardService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "CardController")
@RestController
public class CardController {
	
	@Autowired
    CardService cardService;

	@ApiOperation(value = "findCards")
	@GetMapping("/cards")
    public List<Card> findCards() {
        
        List<Card> cards = (List<Card>) cardService.findAllCards();
        return cards;
    }

	@ApiOperation(value = "addCards")
	@PostMapping("/cards")
    public ResponseEntity<Object> addCard(@RequestBody Card card) {
		card = cardService.addCard(card);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(card.getId()).toUri();
        return ResponseEntity.created(location).build();
    }
	
	@ApiOperation(value = "getcard")
	@GetMapping("/cards/{id}")
	public Card retrieveCard(@PathVariable long id) {
		Optional<Card> card = cardService.findById(id);

		if (!card.isPresent())
			throw new CardNotFoundException("id-" + id);

		return card.get();
	}
}

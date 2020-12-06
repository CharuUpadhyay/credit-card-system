package co.uk.credit.card.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import co.uk.credit.card.model.Card;
import co.uk.credit.card.model.FetchCardsResponse;
import co.uk.credit.card.model.Response;
import co.uk.credit.card.service.CardService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "CardController")
@RestController
public class CardController {
	
	private static final String SUCCESS = "SUCCESS";
	private static final String FAIL = "FAIL";

	@Autowired
    CardService cardService;

	@RequestMapping("/")
	public ModelAndView index() {
		ModelAndView mav = new ModelAndView("index");
		return mav;
	}
	
	@ApiOperation(value = "fetchCards")
	@GetMapping("/fetchCards")
    public FetchCardsResponse findCards() {
        
        List<Card> cards = (List<Card>) cardService.findAllCards();
        FetchCardsResponse response = new FetchCardsResponse();
        if(cards != null) {
        	response.setCards(cards);
        	response.setStatus(SUCCESS);
        	
        }else {
        	response.setStatus(FAIL);
        }
        return response;
    }

	@ApiOperation(value = "addCard")
	@PostMapping("/addCard")
    public Response addCard(@RequestBody Card card) {
		try {
			card = cardService.addCard(card);

			return new Response(SUCCESS, "Card Added successfully");
			
		}catch(Exception e) {
			return new Response(FAIL, e.getMessage());

		}
    }
	
}

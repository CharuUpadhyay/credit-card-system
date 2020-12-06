package co.uk.credit.card.exception;

public class CardNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3878328332974412703L;

	public CardNotFoundException(String exception) {
		super(exception);
	}

}

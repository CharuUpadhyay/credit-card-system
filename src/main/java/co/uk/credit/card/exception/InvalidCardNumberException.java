package co.uk.credit.card.exception;

public class InvalidCardNumberException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3878328332974412703L;

	public InvalidCardNumberException(String exception) {
		super(exception);
	}

}

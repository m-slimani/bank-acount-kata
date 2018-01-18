package kata.bank.account;

public class FunctionnalException extends Exception {

	/**
	 * Serial ID
	 */
	private static final long serialVersionUID = 5373541214296139907L;

	public FunctionnalException(String message) {
		super(message);
	}

	public FunctionnalException(Throwable cause) {
		super(cause);
	}
}

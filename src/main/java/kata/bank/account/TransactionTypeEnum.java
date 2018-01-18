package kata.bank.account;

public enum TransactionTypeEnum {
	WITHDRAW(Constantes.TRANSACTION_TYPE_WITHDRAW);

	private final String type;

	/**
	 * @param type
	 */
	private TransactionTypeEnum(final String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return type;
	}

}

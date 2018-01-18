package kata.bank.account;

public enum TransactionTypeEnum {
	WITHDRAW("Withdraw")
    ;

    private final String type;

    /**
     * @param type
     */
    private TransactionTypeEnum(final String type) {
        this.type = type;
    }

    /* (non-Javadoc)
     * @see java.lang.Enum#toString()
     */
    @Override
    public String toString() {
        return type;
    }

}

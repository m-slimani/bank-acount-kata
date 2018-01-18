package kata.bank.account.domain;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import kata.bank.account.TransactionTypeEnum;

/**
 * 
 * @author pc BankAccount class, allows calculating new balance after withdraw
 *         and reports transaction
 */
public class BankAccount {

	/**
	 * D ate formatter yyyy/MM/dd
	 */
	private static final String DATE_FORMAT = "yyyy/MM/dd";

	private SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);

	/**
	 * Bank Acount Number
	 */
	private String accountNumber;

	/**
	 * Name of the banck account client
	 */
	private String clientName;

	/**
	 * Bank acount current balance
	 */
	private Amount accountBalance;

	/**
	 * History of transactions performed on the bank account
	 */
	private Map<String, String> accountHistory;

	/**
	 * Constructor to instantiate BankAccount
	 * 
	 * @param accountNumber
	 * @param clientName
	 * @param accountBalance
	 */
	public BankAccount(String accountNumber, String clientName, Amount accountBalance) {
		this.accountNumber = accountNumber;
		this.clientName = clientName;
		this.accountBalance = accountBalance;
	}

	/**
	 * Withdraw amount of money from the current balance and update it to new
	 * balance
	 * 
	 * @param withdrawValue
	 */
	public void executeWithdrawTransaction(Amount withdrawValue) {
		// Declare a transaction
		MoneyTransaction transaction = new MoneyTransaction(withdrawValue);
		// The new balance is affected to the bankAcount
		this.accountBalance = transaction.performWithdraw(accountBalance);

		recordTransaction(withdrawValue, transaction.getStatus());

	}

	private void recordTransaction(Amount withdrawValue, String status) {
		Date date = new Date();
		// Recording history of the transaction into a map
		String messageHistory = sdf.format(date) + " : " + status + " " + TransactionTypeEnum.WITHDRAW.name()
				+ " Amount : " + withdrawValue.moneyValue() + " New balance : " + accountBalance.moneyValue();
		accountHistory = new HashMap<String, String>();
		accountHistory.put(sdf.format(date), messageHistory);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BankAccount other = (BankAccount) obj;
		if (accountBalance == null) {
			if (other.accountBalance != null)
				return false;
		} else if (!accountBalance.equals(other.accountBalance))
			return false;
		if (accountNumber == null) {
			if (other.accountNumber != null)
				return false;
		} else if (!accountNumber.equals(other.accountNumber))
			return false;
		if (clientName == null) {
			if (other.clientName != null)
				return false;
		} else if (!clientName.equals(other.clientName))
			return false;
		return true;
	}
}

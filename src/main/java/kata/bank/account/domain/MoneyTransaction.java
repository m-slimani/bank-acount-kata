package kata.bank.account.domain;

import java.util.logging.Level;
import java.util.logging.Logger;

import kata.bank.account.Constantes;
import kata.bank.account.FunctionnalException;

/**
 * 
 * @author pc Money transaction class. Declared with a value
 */
public class MoneyTransaction {

	private static final Logger LOGGER = Logger.getLogger(MoneyTransaction.class.getName());

	/**
	 * Value to perform on the balance
	 */
	private Amount value;

	/**
	 * Value to perform on the balance
	 */
	private String status;

	/**
	 * Declare the value of the transaction
	 * 
	 * @param value
	 */
	public MoneyTransaction(Amount value) {
		this.value = value;
	}

	/**
	 * Substract value from the current balance
	 * 
	 * @param currentBalance
	 * @return
	 */
	public Amount performWithdraw(Amount currentBalance) {
		try {
			currentBalance = currentBalance.withdrawAmount(value);
			this.status = Constantes.TRANSACTION_STATUS_SUCCESS;
		} catch (FunctionnalException e) {
			this.status = Constantes.TRANSACTION_STATUS_FAILLED;
			LOGGER.log(Level.SEVERE, e.getMessage(), e);
		}
		return currentBalance;
	}

	public String getStatus() {
		return status;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MoneyTransaction other = (MoneyTransaction) obj;
		if (value == null) {
			if (other.value != null)
				return false;
		} else if (!value.equals(other.value))
			return false;
		return true;
	}

}

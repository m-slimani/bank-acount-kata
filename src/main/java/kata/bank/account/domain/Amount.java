package kata.bank.account.domain;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Currency;
import java.util.Locale;

import kata.bank.account.FunctionnalException;

/**
 * 
 * @author pc Ammount class
 */
public class Amount {

	/**
	 * Decimal format with two digits after comma "#.00"
	 */
	private static final DecimalFormat DECIMAL_FORMAT = new DecimalFormat("#.00");

	/**
	 * The decimal value of the amount
	 */
	private BigDecimal amountValue;
	/**
	 * Currency of the amount
	 */
	private Currency amountCurrency;

	public Amount(BigDecimal amountValue, Currency amountCurrency) {
		this.amountValue = amountValue;
		this.amountCurrency = amountCurrency;
	}

	public Amount withdrawAmount(Amount withdrawValue) throws FunctionnalException {
		return minusAmount(withdrawValue);
	}

	/**
	 * subtract otherAmount value from this amout value
	 * 
	 * @param otherAmount
	 * @return
	 * @throws FunctionnalException
	 */
	public Amount minusAmount(Amount otherAmount) throws FunctionnalException {
		if (!this.amountCurrency.equals(otherAmount.amountCurrency)) {
			throw new FunctionnalException("The currency of the amount to withdraw : (" + otherAmount.amountCurrency
					+ ") is not the same than the currency of the balance :" + this.amountCurrency);
		}
		return getAmountOf(this.amountValue.subtract(otherAmount.amountValue), Currency.getInstance(Locale.FRANCE));
	}

	/**
	 * build Amount from value and Currency
	 * 
	 * @param value
	 * @param currency
	 * @return
	 */
	public static Amount getAmountOf(BigDecimal value, Currency currency) {
		return new Amount(value, currency);
	}

	/**
	 * Format the value with DECIMAL_FORMAT
	 * 
	 * @return
	 */
	public String moneyValue() {
		return DECIMAL_FORMAT.format(amountValue);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Amount other = (Amount) obj;
		if (amountCurrency == null) {
			if (other.amountCurrency != null)
				return false;
		} else if (!amountCurrency.equals(other.amountCurrency))
			return false;
		if (amountValue == null) {
			if (other.amountValue != null)
				return false;
		} else if (!amountValue.equals(other.amountValue))
			return false;
		return true;
	}
}

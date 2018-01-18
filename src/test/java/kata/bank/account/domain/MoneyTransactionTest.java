package kata.bank.account.domain;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.Locale;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import kata.bank.account.Constantes;

public class MoneyTransactionTest {

	@Test
	public void TestPerformWithdraw() {
		Amount currentBalance = Amount.getAmountOf(new BigDecimal(Constantes.THOUSAND_DECIMAL_CHAIN),
				Currency.getInstance(Locale.FRANCE));
		Amount withdrawHundred = Amount.getAmountOf(new BigDecimal(Constantes.HUNDRED_DECIMAL_CHAIN),
				Currency.getInstance(Locale.FRANCE));
		Amount expectedBalance = Amount.getAmountOf(new BigDecimal(Constantes.NINE_HUNDRED_DECIMAL_CHAIN),
				Currency.getInstance(Locale.FRANCE));

		// Declare a transaction with a current balance
		MoneyTransaction transaction = new MoneyTransaction(withdrawHundred);
		// Calculating of the new balance
		Amount newBalance = transaction.performWithdraw(currentBalance);

		Assertions.assertEquals(expectedBalance, newBalance);
	}

}

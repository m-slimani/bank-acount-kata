package kata.bank.account.domain;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.Locale;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MoneyTransactionTest {

	@Test
	public void TestPerformWithdraw() {
		Amount currentBalance = Amount.getAmountOf(new BigDecimal("1000.00"), Currency.getInstance(Locale.FRANCE));
		Amount withdrawHundred = Amount.getAmountOf(new BigDecimal("100.00"), Currency.getInstance(Locale.FRANCE));
		Amount expectedBalance = Amount.getAmountOf(new BigDecimal("900.00"), Currency.getInstance(Locale.FRANCE));
		
		//Declare a transaction with a current balance
		MoneyTransaction transaction = new MoneyTransaction(withdrawHundred);
		//Calculating of the new balance
		Amount newBalance = transaction.performWithdraw(currentBalance);
		
		Assertions.assertEquals(expectedBalance, newBalance);
	}

}

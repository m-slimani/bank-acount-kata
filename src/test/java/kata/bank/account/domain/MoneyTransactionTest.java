package kata.bank.account.domain;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.Locale;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MoneyTransactionTest {
	
	private static final String THOUSAND = "1000.00";
	private static final String HUNDRED = "100.00";
	private static final String NINE_HUNDRED = "900.00";

	@Test
	public void TestPerformWithdraw() {
		Amount currentBalance = Amount.getAmountOf(new BigDecimal(THOUSAND), Currency.getInstance(Locale.FRANCE));
		Amount withdrawHundred = Amount.getAmountOf(new BigDecimal(HUNDRED), Currency.getInstance(Locale.FRANCE));
		Amount expectedBalance = Amount.getAmountOf(new BigDecimal(NINE_HUNDRED), Currency.getInstance(Locale.FRANCE));
		
		//Declare a transaction with a current balance
		MoneyTransaction transaction = new MoneyTransaction(withdrawHundred);
		//Calculating of the new balance
		Amount newBalance = transaction.performWithdraw(currentBalance);
		
		Assertions.assertEquals(expectedBalance, newBalance);
	}

}

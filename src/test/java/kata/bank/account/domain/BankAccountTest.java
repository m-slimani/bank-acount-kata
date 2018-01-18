package kata.bank.account.domain;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.Date;
import java.util.Locale;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BankAccountTest {

	private static final String ACCOUNT_NUMBER = "123456";
	private static final String CLIENT_NAME = "pierre-jean";

	@Test
	public void TestWithDraw_PositiveBalance() {
		Amount ninety = Amount.getAmountOf(new BigDecimal("90.00"), Currency.getInstance(Locale.FRANCE));
		BankAccount accountBalanceHundred = new BankAccount(ACCOUNT_NUMBER, CLIENT_NAME,
				Amount.getAmountOf(new BigDecimal("100.00"), Currency.getInstance(Locale.FRANCE)));
		BankAccount accountBalanceTen = new BankAccount(ACCOUNT_NUMBER, CLIENT_NAME,
				Amount.getAmountOf(new BigDecimal("10.00"), Currency.getInstance(Locale.FRANCE)));

		accountBalanceHundred.executeWithdrawTransaction(ninety);
		Assertions.assertEquals(accountBalanceHundred, accountBalanceTen);
	}

	@Test
	public void TestWithDraw_ZeroBalance() {
		Amount fifty = Amount.getAmountOf(new BigDecimal("50.00"), Currency.getInstance(Locale.FRANCE));
		BankAccount accountBalanceFifty = new BankAccount(ACCOUNT_NUMBER, CLIENT_NAME,
				Amount.getAmountOf(new BigDecimal("50.00"), Currency.getInstance(Locale.FRANCE)));
		BankAccount accountBalanceZero = new BankAccount(ACCOUNT_NUMBER, CLIENT_NAME,
				Amount.getAmountOf(new BigDecimal("0.00"), Currency.getInstance(Locale.FRANCE)));

		accountBalanceFifty.executeWithdrawTransaction(fifty);
		Assertions.assertEquals(accountBalanceFifty, accountBalanceZero);
	}

	@Test
	public void TestWithDraw_NegativeBalance() {
		Amount hundred = Amount.getAmountOf(new BigDecimal("100.00"), Currency.getInstance(Locale.FRANCE));
		BankAccount accountBalanceFifty = new BankAccount(ACCOUNT_NUMBER, CLIENT_NAME,
				Amount.getAmountOf(new BigDecimal("50.00"), Currency.getInstance(Locale.FRANCE)));
		BankAccount accountBalanceMinusFifty = new BankAccount(ACCOUNT_NUMBER, CLIENT_NAME,
				Amount.getAmountOf(new BigDecimal("-50.00"), Currency.getInstance(Locale.FRANCE)));

		accountBalanceFifty.executeWithdrawTransaction(hundred);
		Assertions.assertEquals(accountBalanceFifty, accountBalanceMinusFifty);
	}

}

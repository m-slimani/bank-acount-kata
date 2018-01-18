package kata.bank.account.domain;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.Locale;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BankAccountTest {

	private static final String TEN = "10.00";
	private static final String HUNDRED = "100.00";
	private static final String NINETY = "90.00";
	private static final String FIFTY = "50.00";
	private static final String ZERO = "0.00";
	private static final String ACCOUNT_NUMBER = "123456";
	private static final String CLIENT_NAME = "pierre-jean";
	private static final String FIFTY_NEGATIVE = "-50.00";

	@Test
	public void TestWithDraw_PositiveBalance() {
		Amount ninety = Amount.getAmountOf(new BigDecimal(NINETY), Currency.getInstance(Locale.FRANCE));
		BankAccount accountBalanceHundred = new BankAccount(ACCOUNT_NUMBER, CLIENT_NAME,
				Amount.getAmountOf(new BigDecimal(HUNDRED), Currency.getInstance(Locale.FRANCE)));
		BankAccount accountBalanceTen = new BankAccount(ACCOUNT_NUMBER, CLIENT_NAME,
				Amount.getAmountOf(new BigDecimal(TEN), Currency.getInstance(Locale.FRANCE)));

		accountBalanceHundred.executeWithdrawTransaction(ninety);
		Assertions.assertEquals(accountBalanceHundred, accountBalanceTen);
	}

	@Test
	public void TestWithDraw_ZeroBalance() {
		Amount fifty = Amount.getAmountOf(new BigDecimal(FIFTY), Currency.getInstance(Locale.FRANCE));
		BankAccount accountBalanceFifty = new BankAccount(ACCOUNT_NUMBER, CLIENT_NAME,
				Amount.getAmountOf(new BigDecimal(FIFTY), Currency.getInstance(Locale.FRANCE)));
		BankAccount accountBalanceZero = new BankAccount(ACCOUNT_NUMBER, CLIENT_NAME,
				Amount.getAmountOf(new BigDecimal(ZERO), Currency.getInstance(Locale.FRANCE)));

		accountBalanceFifty.executeWithdrawTransaction(fifty);
		Assertions.assertEquals(accountBalanceFifty, accountBalanceZero);
	}

	@Test
	public void TestWithDraw_NegativeBalance() {
		Amount hundred = Amount.getAmountOf(new BigDecimal(HUNDRED), Currency.getInstance(Locale.FRANCE));
		BankAccount accountBalanceFifty = new BankAccount(ACCOUNT_NUMBER, CLIENT_NAME,
				Amount.getAmountOf(new BigDecimal(FIFTY), Currency.getInstance(Locale.FRANCE)));
		BankAccount accountBalanceMinusFifty = new BankAccount(ACCOUNT_NUMBER, CLIENT_NAME,
				Amount.getAmountOf(new BigDecimal(FIFTY_NEGATIVE), Currency.getInstance(Locale.FRANCE)));

		accountBalanceFifty.executeWithdrawTransaction(hundred);
		Assertions.assertEquals(accountBalanceFifty, accountBalanceMinusFifty);
	}

}

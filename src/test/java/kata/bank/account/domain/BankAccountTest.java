package kata.bank.account.domain;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.Locale;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import kata.bank.account.Constantes;

public class BankAccountTest {

	@Test
	public void TestWithDraw_PositiveBalance() {
		Amount ninety = Amount.getAmountOf(new BigDecimal(Constantes.NINETY_DECIMAL_CHAIN), Currency.getInstance(Locale.FRANCE));
		BankAccount accountBalanceHundred = new BankAccount(Constantes.ACCOUNT_NUMBER_FOR_TEST, Constantes.CLIENT_NAME_FOR_TEST,
				Amount.getAmountOf(new BigDecimal(Constantes.HUNDRED_DECIMAL_CHAIN), Currency.getInstance(Locale.FRANCE)));
		BankAccount accountBalanceTen = new BankAccount(Constantes.ACCOUNT_NUMBER_FOR_TEST, Constantes.CLIENT_NAME_FOR_TEST,
				Amount.getAmountOf(new BigDecimal(Constantes.TEN_DECIMAL_CHAIN), Currency.getInstance(Locale.FRANCE)));

		accountBalanceHundred.executeWithdrawTransaction(ninety);
		Assertions.assertEquals(accountBalanceHundred, accountBalanceTen);
	}

	@Test
	public void TestWithDraw_ZeroBalance() {
		Amount fifty = Amount.getAmountOf(new BigDecimal(Constantes.FIFTY_DECIMAL_CHAIN), Currency.getInstance(Locale.FRANCE));
		BankAccount accountBalanceFifty = new BankAccount(Constantes.ACCOUNT_NUMBER_FOR_TEST, Constantes.CLIENT_NAME_FOR_TEST,
				Amount.getAmountOf(new BigDecimal(Constantes.FIFTY_DECIMAL_CHAIN), Currency.getInstance(Locale.FRANCE)));
		BankAccount accountBalanceZero = new BankAccount(Constantes.ACCOUNT_NUMBER_FOR_TEST, Constantes.CLIENT_NAME_FOR_TEST,
				Amount.getAmountOf(new BigDecimal(Constantes.ZERO_DECIMAL_CHAIN), Currency.getInstance(Locale.FRANCE)));

		accountBalanceFifty.executeWithdrawTransaction(fifty);
		Assertions.assertEquals(accountBalanceFifty, accountBalanceZero);
	}

	@Test
	public void TestWithDraw_NegativeBalance() {
		Amount hundred = Amount.getAmountOf(new BigDecimal(Constantes.HUNDRED_DECIMAL_CHAIN), Currency.getInstance(Locale.FRANCE));
		BankAccount accountBalanceFifty = new BankAccount(Constantes.ACCOUNT_NUMBER_FOR_TEST, Constantes.CLIENT_NAME_FOR_TEST,
				Amount.getAmountOf(new BigDecimal(Constantes.FIFTY_DECIMAL_CHAIN), Currency.getInstance(Locale.FRANCE)));
		BankAccount accountBalanceMinusFifty = new BankAccount(Constantes.ACCOUNT_NUMBER_FOR_TEST, Constantes.CLIENT_NAME_FOR_TEST,
				Amount.getAmountOf(new BigDecimal(Constantes.FIFTY_NEGATIVE_DECIMAL_CHAIN), Currency.getInstance(Locale.FRANCE)));

		accountBalanceFifty.executeWithdrawTransaction(hundred);
		Assertions.assertEquals(accountBalanceFifty, accountBalanceMinusFifty);
	}

}

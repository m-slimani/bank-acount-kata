package kata.bank.account.domain;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.Locale;
import java.util.logging.Logger;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import kata.bank.account.Constantes;
import kata.bank.account.FunctionnalException;

public class AmountTest {

	private static final Logger LOGGER = Logger.getLogger(AmountTest.class.getName());
	
	

	@Test
	public void TestWithDraw_PositiveBalance() throws FunctionnalException {
		Amount hundred = Amount.getAmountOf(new BigDecimal(Constantes.HUNDRED_DECIMAL_CHAIN), Currency.getInstance(Locale.FRANCE));
		Amount ninety = Amount.getAmountOf(new BigDecimal(Constantes.NINETY_DECIMAL_CHAIN), Currency.getInstance(Locale.FRANCE));
		Amount ten = Amount.getAmountOf(new BigDecimal(Constantes.TEN_DECIMAL_CHAIN), Currency.getInstance(Locale.FRANCE));

		Assertions.assertEquals(hundred.withdrawAmount(ten), ninety);
	}

	@Test
	public void TestWithDraw_ZeroBalance() throws FunctionnalException {
		Amount ten = Amount.getAmountOf(new BigDecimal(Constantes.TEN_DECIMAL_CHAIN), Currency.getInstance(Locale.FRANCE));
		Amount zero = Amount.getAmountOf(new BigDecimal(Constantes.ZERO_DECIMAL_CHAIN), Currency.getInstance(Locale.FRANCE));

		Assertions.assertEquals(ten.withdrawAmount(ten), zero);
	}

	@Test
	public void TestWithDraw_NegativeBalance() throws FunctionnalException {
		Amount ten = Amount.getAmountOf(new BigDecimal(Constantes.TEN_DECIMAL_CHAIN), Currency.getInstance(Locale.FRANCE));
		Amount hundred = Amount.getAmountOf(new BigDecimal(Constantes.HUNDRED_DECIMAL_CHAIN), Currency.getInstance(Locale.FRANCE));
		Amount minusNinety = Amount.getAmountOf(new BigDecimal(Constantes.NINETY_NEGATIVE_DECIMAL_CHAIN), Currency.getInstance(Locale.FRANCE));
		Amount ninety = Amount.getAmountOf(new BigDecimal(Constantes.NINETY_DECIMAL_CHAIN), Currency.getInstance(Locale.FRANCE));

		Assertions.assertEquals(ten.withdrawAmount(hundred), minusNinety);
		Assertions.assertNotEquals(ten.withdrawAmount(hundred), ninety);
	}

	@Test
	public void TestWithDraw_DifferentCurrency() {
		Amount hundredEuros = Amount.getAmountOf(new BigDecimal(Constantes.HUNDRED_DECIMAL_CHAIN), Currency.getInstance(Locale.FRANCE));
		Amount hundredUSDollars = Amount.getAmountOf(new BigDecimal(Constantes.HUNDRED_DECIMAL_CHAIN), Currency.getInstance(Locale.US));
		try {
			Assertions.assertSame(FunctionnalException.class, hundredEuros.withdrawAmount(hundredUSDollars),
					"a message");
		} catch (FunctionnalException e) {
			Assertions.assertEquals(
					"The currency of the amount to withdraw : (USD) is not the same than the currency of the balance :EUR",
					e.getMessage());
			Assertions.assertEquals(Constantes.HUNDRED_DECIMAL_CHAIN, hundredEuros.moneyValue());
		}
	}

}

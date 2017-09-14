package org.assume.api.formatting;

import java.text.NumberFormat;
import java.util.Currency;

public class Format {

	public static String getPriceFormatted(Double d) {
		final NumberFormat currencyInstance = NumberFormat.getCurrencyInstance();
		currencyInstance.setCurrency(Currency.getInstance("USD"));
		return currencyInstance.format(d);
	}

}

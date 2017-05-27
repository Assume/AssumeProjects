package org.assume.api.types;

import java.text.NumberFormat;
import java.util.Currency;

public class Purchase {

	private double price;
	private String item;
	private Date date;
	private Category c;

	public Purchase(double price, String item, Date date, Category c) {
		this.price = price;
		this.item = item;
		this.date = date;
		this.c = c;
	}

	public double getPrice() {
		return price;
	}

	public String getPriceFormatted() {
		final NumberFormat currencyInstance = NumberFormat.getCurrencyInstance();
		currencyInstance.setCurrency(Currency.getInstance("USD"));
		return currencyInstance.format(this.price);
	}

	public String getItem() {
		return item;
	}

	public Date getDate() {
		return date;
	}

	public Category getCategory() {
		return c;
	}

	@Override
	public String toString() {
		return "Purchased: " + item + " on " + date.toString() + " for " + getPriceFormatted() + " in the category "
				+ c.toString();
	}
}

package org.assume.api.types;

public enum Month
{
	JANUARY(1, 31),
	FEBRUARY(2, 28),
	MARCH(3, 31),
	APRIL(4, 30),
	MAY(5, 31),
	JUNE(6, 30),
	JULY(7, 31),
	AUGUST(8, 31),
	SEPTEMBER(9, 30),
	OCTOBER(10, 31),
	NOVEMBER(11, 30),
	DECEMBER(12, 31);

	private int monthNumber;
	private int day;
	private String name;
	private Month(int monthNumber, int day)
	{
		name = toTitle();
		this.monthNumber = monthNumber;
		this.day = day;
	}

	public int getMonth()
	{
		return monthNumber;
	}

	public int getDays()
	{
		return day;
	}

	@Override
	public String toString()
	{
		return name;
	}
	
	private String toTitle()
	{
		final StringBuilder sb = new StringBuilder();
		for (final String s : this.name().split("_")) {
			sb.append(Character.toUpperCase(s.charAt(0)));
			sb.append(s.substring(1, s.length()).toLowerCase());
			sb.append(" ");
		}
		return sb.toString().trim();
	}
}

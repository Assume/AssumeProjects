package org.assume.api.types;

public class Category {
	private String name;

	public Category(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return name;
	}

}

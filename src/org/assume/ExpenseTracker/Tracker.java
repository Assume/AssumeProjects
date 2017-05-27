package org.assume.ExpenseTracker;

import java.util.ArrayList;
import java.util.HashMap;

import org.assume.api.types.Category;
import org.assume.api.types.Purchase;

public class Tracker {
	public static void main(String[] args) {
		fillCategoryList();
		previousSize = list.size();
		for (int i = 0; i < Tracker.categoryList.size(); i++) {
			Tracker.totalMap.put(Tracker.categoryList.get(i), 0.0);
		}
		for (Category k : totalMap.keySet()) {
			System.out.println(k.toString());
		}
		GUI frame = new GUI();
		frame.setVisible(true);
	}

	public static ArrayList<Purchase> list = new ArrayList<Purchase>();
	public static ArrayList<Category> categoryList = new ArrayList<Category>();
	public static HashMap<Category, Double> totalMap = new HashMap<Category, Double>();
	private static Category[] categoryArray = { new Category("Food"), new Category("Entertainment"),
			new Category("Travel"), new Category("Health Care"), new Category("Apparel"), new Category("Insurance") };
	private static int previousSize;

	static boolean needToUpdateList() {
		if (previousSize < list.size()) {
			previousSize = list.size();
			return true;
		}
		return false;
	}

	static void fillCategoryList() {
		if (categoryList.isEmpty()) {
			for (Category d : categoryArray) {
				categoryList.add(d);
			}
		}
	}

	static void addNewPurchase(Purchase p) {
		list.add(p);
	}

	static String getPurchaseInfo(Purchase p) {
		return p.toString();
	}
}

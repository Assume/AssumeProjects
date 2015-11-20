package org.assume.dynamicsignatureloader;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DynSignatureLoader {

	/*
	 * Username Runtime Profit
	 */

	public static void main(String[] args) {
		File file = new File(
				"C:\\Users\\Adam\\Google Drive\\signature data backup.txt");
		try {
			long total_profit = 0;
			Scanner in = new Scanner(file);
			while (in.hasNext()) {
				String name = in.nextLine();
				long runtime = Long.parseLong(in.nextLine());
				long profit = Long.parseLong(in.nextLine());
				total_profit += profit;
				System.out.println("name: " + name + " profit: " + profit
						+ " runtime: " + runtime);
			}
			System.out.println(total_profit);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

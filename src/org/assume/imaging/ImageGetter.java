package org.assume.imaging;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Scanner;

public class ImageGetter {

	public static void main(String[] args) throws URISyntaxException, IOException {
		URL url = new URL(new Scanner(System.in).nextLine());
		BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
		String inputLine;
		while ((inputLine = in.readLine()) != null) {

		}
		System.out.println(inputLine);
		in.close();
	}

}

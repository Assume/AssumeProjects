package org.assume.ZybezPriceGrabber;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

public class PriceItem {
	public static int getPrice(String name) {
		try {
			if (name != null && name.length() > 0) {
				URL url = new URL("http://forums.zybez.net/runescape-2007-prices/api/" + name.toLowerCase()
						.replace(" ", "_").replace("(1)", "").replace("(2)", "").replace("(3)", "").replace("(4)", ""));
				HttpURLConnection connection = (HttpURLConnection) url.openConnection();
				connection.setRequestProperty("User-Agent",
						"Mozilla/5.0 (Windows NT 5.1) AppleWebKit/535.11 (KHTML, like Gecko) Chrome/17.0.963.56 Safari/535.11");
				BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
				String inputLine = "";
				int line = 0;
				while ((inputLine = in.readLine()) != null && line < 3) {
					if (inputLine.contains("average")) {
						String s = inputLine.substring(inputLine.indexOf("average") + 10,
								inputLine.indexOf("average") + 21);
						char c[] = s.toCharArray();
						StringBuilder sb = new StringBuilder();
						for (char l : c) {
							if (new String(l + "").equals(".")) {
								return Integer.parseInt(sb.toString());
							} else {
								sb.append(l);
							}
						}
					}
					line++;
				}
				in.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	public static String getNameOnline(int id) {
		try {
			URL url = new URL("http://pastebin.com/raw.php?i=TezDxRyx");
			URLConnection con = url.openConnection();
			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String line;
			while ((line = in.readLine()) != null) {
				if (line.contains(id + ",")) {
					if (line.split(",").length > 2) {
						if (line.split(",")[0].equals("" + id)) {
							return line.split(",")[1];
						}
					}
				}
			}
		} catch (Exception e) {

		}
		return null;
	}
}

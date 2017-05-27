package org.assume.NetworkingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientTest {

	public static void main(String[] args) throws UnknownHostException, IOException {
		Socket s = new Socket("localhost", 1604);
		OutputStreamWriter out = new OutputStreamWriter(s.getOutputStream());
		out.write("Adam");
		System.out.println(new BufferedReader(new InputStreamReader(s.getInputStream())).readLine());
		out.close();
	}

}

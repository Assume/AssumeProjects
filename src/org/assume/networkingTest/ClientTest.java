package org.assume.networkingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientTest {

	public static void main(String[] args) throws UnknownHostException, IOException
	{
		
		Socket sock = new Socket("localhost", 1604);
		
		BufferedReader out = new BufferedReader(new InputStreamReader(sock.getInputStream()));
		System.out.println(out.readLine());
		sock.close();
		out.close();
	}
	
	
}

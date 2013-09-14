package org.assume.NetworkingTest;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class ScriptClientTest
{

	public static void main(String[] args) throws UnknownHostException, IOException
	{
		Socket s = new Socket("localhost", 1604);
		OutputStreamWriter out = new OutputStreamWriter(s.getOutputStream());
		out.write("Adam");
		out.write("script");
	}
	
}

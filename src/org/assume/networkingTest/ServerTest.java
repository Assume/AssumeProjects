package org.assume.networkingTest;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerTest {

	public static void main(String[] args) throws IOException
	{
		@SuppressWarnings("resource")
		ServerSocket serverSock = new ServerSocket(1604);

		while(true)
		{
			Socket in = serverSock.accept();
			BufferedWriter out = new BufferedWriter(new OutputStreamWriter(in.getOutputStream()));
			out.write("Hey6");
			out.flush();
			out.close();
		}
	}


}

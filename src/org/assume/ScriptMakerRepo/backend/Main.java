package org.assume.ScriptMakerRepo.backend;

import java.io.IOException;
import java.net.ServerSocket;

public class Main
{

	public static void main(String[] args) throws IOException
	{
		new Main().acceptConnections();
	}
	
	public void acceptConnections() throws IOException
	{
		ServerSocket s = new ServerSocket(1604);
		while(true)
		{
			new Thread(new ConnectionHandler(s.accept())).start();
		}
	}
	
}

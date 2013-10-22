package org.assume.ScriptMakerRepo.backend;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

import org.assume.ScriptMakerRepo.backend.UploadManager.UploadHandler;

public class ConnectionHandler implements Runnable
{

	private Socket sock;
	
	public ConnectionHandler(Socket sock)
	{
		this.sock = sock;
		
	}
	
	@Override
	public void run()
	{
		String command;
		if(sock.isConnected())
		{
			try
			{
				command = new BufferedReader(new InputStreamReader(sock.getInputStream())).readLine();
				if(command.contains("upload"))
				{
					sock.setKeepAlive(true);
					new Thread(new UploadHandler(sock)).start();
				}
			}
			catch (IOException e)
			{
				e.printStackTrace();
				return;
			}
		}
		
	}

}

package org.assume.ScriptMakerRepo.backend.UploadManager;

import java.net.Socket;

public class UploadHandler implements Runnable
{

	private Socket sock;
	
	public UploadHandler(Socket sock)
	{
		this.sock = sock;
	}
	
	@Override
	public void run()
	{
		if(sock.isConnected())
		{
			//SciptFile f = (ScriptFile) new ObjectInputStream(sock.getInputStream()).readObject();
		}
	}

}

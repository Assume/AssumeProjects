package org.assume.ScriptInformation.client;
import java.io.*;

import java.net.*;

import scripts.*;

public class DisplayClient
{

	public static void main(String[] args) throws UnknownHostException, IOException
	{
		DisplayClient c = new DisplayClient();
		c.updateInfo();
	}

	public void updateInfo() throws UnknownHostException, IOException
	{
		try
		{
			Socket mySock = new Socket("localhost", 1604);
			ObjectOutputStream out = new ObjectOutputStream(mySock.getOutputStream());
			ScriptStatus k = new ScriptStatus();
			k.setScriptName("Fighter");
			k.setUsername("Player29");
			k.setScriptStatus("Stopped");
			k.addInformation("Runtime", "12 minutes");
			k.addInformation("Status", "Attacking");
			k.addInformation("Monsters Killed", "300");
			k.refreshInformation();
			out.writeObject(k);
			mySock.close();
			out.flush();
			out.close();
		} catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}



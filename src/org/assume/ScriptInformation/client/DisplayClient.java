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
			Socket mySock = new Socket("204.152.219.74", 1604);
			ObjectOutputStream out = new ObjectOutputStream(mySock.getOutputStream());
			ScriptStatus k = new ScriptStatus();
			k.setScriptName("CombatAIO");
			k.setUsername("Adaaam");
			k.setScriptStatus("Dead");
			k.addInformation("Runtime", "8 minutes");
			k.addInformation("Status", "Fred");
			k.addInformation("Kill count", "500");
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



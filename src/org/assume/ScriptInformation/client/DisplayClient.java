package org.assume.ScriptInformation.client;
import java.io.*;

import java.net.*;
import java.util.Random;

import scripts.ScriptStatus;


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
			for(int i = 0; i < 25; i++)
			{
				Socket mySock = new Socket("localhost", 1604);
				ObjectOutputStream out = new ObjectOutputStream(mySock.getOutputStream());
				ScriptStatus k = new ScriptStatus();
				String[] g = {"Running", "Paused/Random","Stopped"};
				k = new ScriptStatus();
				k.setScriptName("TestScript"+new Random().nextInt(25));
				k.setUsername("T"+new Random().nextInt(100));
				k.setScriptStatus(g[new Random().nextInt(3)]);
				k.addInformation("Runtime", "13 minutes");
				k.addInformation("Status", "Sleep");
				k.addInformation("TestData", "300");
				k.addInformation("TestData1", "Fun");
				out.writeObject(k);
				mySock.close();
				out.flush();
				out.close();
			}
		} catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}



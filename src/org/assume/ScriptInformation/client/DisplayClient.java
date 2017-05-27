package org.assume.ScriptInformation.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

public class DisplayClient {

	public static void main(String[] args) throws UnknownHostException, IOException {
		DisplayClient c = new DisplayClient();
		c.updateInfo();
	}

	public void updateInfo() throws UnknownHostException, IOException {
		try {
			while (true) {
				Socket mySock = new Socket("localhost", 1604);
				System.out.println(new BufferedReader(new InputStreamReader(mySock.getInputStream())).readLine());
				mySock.close();
			}

			/*
			 * ObjectOutputStream out = new
			 * ObjectOutputStream(mySock.getOutputStream()); ScriptStatus k =
			 * new ScriptStatus(); String[] g = {"Running",
			 * "Paused/Random","Stopped"}; k = new ScriptStatus();
			 * k.setScriptName("TestScript"+new Random().nextInt(25));
			 * k.setUsername("T"+new Random().nextInt(100));
			 * k.setScriptStatus(g[new Random().nextInt(3)]);
			 * k.addInformation("Runtime", "13 minutes");
			 * k.addInformation("Status", "Sleep"); k.addInformation("TestData",
			 * "300"); k.addInformation("TestData1", "Fun"); out.writeObject(k);
			 * 
			 * 
			 * out.flush(); out.close();
			 */

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

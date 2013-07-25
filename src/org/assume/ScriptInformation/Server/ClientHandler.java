package org.assume.ScriptInformation.Server;


import java.io.ObjectInputStream;
import java.net.Socket;

import org.assume.ScriptInformation.GUI.GUIHandler;
import org.assume.ScriptInformation.client.Updater;

import scripts.*;

class ClientHandler implements Runnable{

	private Socket listener;

	public ClientHandler(Socket listener) {
		this.listener = listener;
	}

	@Override
	public void run() {
		if(!listener.isClosed())
		{
			try {
				ObjectInputStream inStream = new ObjectInputStream(
						listener.getInputStream());
				try {
					ScriptStatus script = (ScriptStatus) inStream
							.readObject();
					if(script != null)
					{
						Updater.update(script.getUsername(), script);
						GUIHandler.updateScriptList(Updater.map, script.getUsername());
					}
				} catch (Exception ex) {
					ex.printStackTrace();
				}
				inStream.close();
			}catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	}


}
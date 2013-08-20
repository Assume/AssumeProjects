package org.assume.ScriptInformation.Server.handlers;


import java.io.ObjectInputStream;
import java.net.Socket;

import org.assume.ScriptInformation.client.Database;
import org.assume.ScriptInformation.GUI.handlers.GUIHandler;

import scripts.ScriptStatus;


public class ClientHandler implements Runnable{

	private Socket listener;
	private final GUIHandler handler = new GUIHandler();
	private final Database database = new Database();
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
						Database.update(script.getUsername(), script);
						handler.updateScriptList(Database.map, script.getUsername());
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
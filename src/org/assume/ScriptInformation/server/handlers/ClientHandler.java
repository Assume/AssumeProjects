package org.assume.ScriptInformation.server.handlers;


import java.io.ObjectInputStream;
import java.net.Socket;

import org.assume.ScriptInformation.client.Updater;
import org.assume.ScriptInformation.gui.handlers.GUIHandler;

import scripts.*;

public class ClientHandler implements Runnable{

	private Socket listener;
	private final GUIHandler handler = new GUIHandler();
	private final Updater updater = new Updater();
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
						updater.update(script.getUsername(), script);
						handler.updateScriptList(Updater.map, script.getUsername());
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
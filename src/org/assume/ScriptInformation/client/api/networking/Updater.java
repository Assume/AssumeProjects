package org.assume.ScriptInformation.client.api.networking;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import scripts.ScriptStatus;

public abstract class Updater extends Thread {

	public void updateInfo(ScriptStatus s, String ip, int port) throws UnknownHostException, IOException {
		try {
			if (port != -1 && ip != null) {
				Socket mySock = new Socket(ip, port);
				ObjectOutputStream out = new ObjectOutputStream(mySock.getOutputStream());
				out.writeObject(s);
				mySock.close();
				out.flush();
				out.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected abstract int update();

	@Override
	public void run() {
		while (true) {
			try {
				Thread.sleep(update());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}

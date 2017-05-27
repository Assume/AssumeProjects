package org.assume.NetworkingTest;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class ClientHandler implements Runnable {
	private Socket socket;
	private String userName;

	public ClientHandler(Socket socket, String userName) {
		this.socket = socket;
		this.userName = userName;
	}

	@Override
	public void run() {
		if (!socket.isClosed()) {
			if (Server.s.isClientConnected(this.userName)) {
				Socket client = Server.s.getClient(this.userName);
				try {
					OutputStreamWriter out = new OutputStreamWriter(client.getOutputStream());
					out.write("Hi");
					out.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}

}

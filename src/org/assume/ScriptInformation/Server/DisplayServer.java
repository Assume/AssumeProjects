package org.assume.ScriptInformation.Server;

import java.io.IOException;

import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JOptionPane;

import org.assume.ScriptInformation.GUI.GUI;
import org.assume.ScriptInformation.Server.handlers.ClientHandler;

public class DisplayServer {
	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		int port = Integer.parseInt(JOptionPane.showInputDialog(
				"Enter port for sever. Make sure you enter the same one on the script. Make sure the port is forwarded: "));
		GUI frame = new GUI();
		frame.setVisible(true);
		ServerSocket mySock = new ServerSocket(port);
		while (true) {
			Socket accept = mySock.accept();
			new Thread(new ClientHandler(accept)).start();
		}
	}

}

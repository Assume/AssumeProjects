package org.assume.ScriptInformation.Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JOptionPane;

import org.assume.ScriptInformation.GUI.GUI;



public class DisplayServer 
{
	public static void main(String[] args) throws IOException, ClassNotFoundException
	{
		int port = Integer.parseInt(JOptionPane.showInputDialog("Enter port for sever. Make sure you enter the same one on the script. Make sure the port if forwarded: "));
		DisplayServer serv = new DisplayServer();
		GUI frame = new GUI();
		frame.setVisible(true);
		ServerSocket mySock = new ServerSocket(1604);
		while(true)
		{
			Socket accept = mySock.accept();
			new Thread(new ClientHandler(accept)).start();
		}
	}

}

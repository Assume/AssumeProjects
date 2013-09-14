package org.assume.NetworkingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Server
{
	private ServerSocket sock;
	private Map<String, Socket> scriptClientMap;
	private Map<String, Socket> clientMap;
	private List<Socket> clientList;

	public Server() throws IOException
	{
		sock = new ServerSocket(1604);
		clientMap = new HashMap<String, Socket>();
		scriptClientMap = new HashMap<String, Socket>();
		clientList = new ArrayList<Socket>();
	}

	public void handleConnections() throws IOException
	{
		while (true)
		{
			Socket clientSocket = sock.accept();
			BufferedReader b = new BufferedReader(new InputStreamReader(
					clientSocket.getInputStream()));
			String s = b.readLine();
			String d = b.readLine();
			if(d != null || s != null)
			{
				if (d.equals("script"))
				{
					scriptClientMap.put(s, clientSocket);
					clientList.add(clientSocket);
					new Thread(new ClientHandler(clientSocket, s)).start();
				}
				else
				{
					clientMap.put(s, clientSocket);
				}
			}
		}
	}

	public Socket[] getClients()
	{
		return this.clientList.toArray(new Socket[this.clientList.size()]);
	}

	public boolean isClientConnected(String userName)
	{
		return this.clientMap.containsKey(userName);
	}

	public Socket getClient(String userName)
	{
		return this.clientMap.get(userName);
	}

	public static Server s;

	public static void main(String[] args) throws IOException
	{
		s = new Server();
		s.handleConnections();
	}

}

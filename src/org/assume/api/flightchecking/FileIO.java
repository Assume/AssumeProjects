package org.assume.api.flightchecking;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

import org.assume.api.types.Flight;

public class FileIO
{

	public static void loadAllFlights() throws IOException,
			ClassNotFoundException
	{
		if (new File(System.getProperty("user.home") + File.separator
				+ "Documents" + File.separator + "FlightFiles").exists())
		{
			File[] files = new File(System.getProperty("user.home")
					+ File.separator + "Documents" + File.separator
					+ "FlightFiles").listFiles();
			for (File f : files)
			{
				InputStream fileIn = new FileInputStream(f);
				ObjectInputStream ois = new ObjectInputStream(fileIn);
				Flight fl = (Flight) ois.readObject();
				if (!GUI.flights.contains(fl))
				{
					GUI.flights.add(fl);
				}
				ois.close();
				fileIn.close();
			}
		}
	}

	public static void save(Flight f) throws IOException
	{
		
		if(!new File(System.getProperty("user.home")
				+ File.separator + "Documents" + File.separator + "FlightFiles").exists())
				{
			new File(System.getProperty("user.home")
					+ File.separator + "Documents" + File.separator + "FlightFiles").mkdir();
				}
		File directory = new File(System.getProperty("user.home")
				+ File.separator + "Documents" + File.separator + "FlightFiles"
				+ File.separator + f.getConfirmationNumber() + ".flight");

		OutputStream fileOut = new FileOutputStream(directory);
		ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
		objectOut.writeObject(f);

		fileOut.flush();
		fileOut.close();
		objectOut.flush();
		objectOut.close();
	}

	public static void main(String[] args)
	{

	}

}

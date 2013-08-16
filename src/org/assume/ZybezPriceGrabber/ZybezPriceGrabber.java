package org.assume.ZybezPriceGrabber;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ZybezPriceGrabber {

	static FileWriterMe me;
	public static void main(String[] args) throws IOException
	{
		me = new FileWriterMe(new File("C:\\Users\\Adam\\SkyDrive\\"+"itemprices.txt"));
		long start = System.currentTimeMillis();
		File f = new File("C:\\Users\\Adam\\SkyDrive\\"+"items.txt");
		BufferedReader in = new BufferedReader(new FileReader(f));
		String line;
		while((line = in.readLine()) != null)
		{
			new Thread(new Handler(line.substring(line.indexOf(","),line.lastIndexOf(",")).replace(",", ""))).start();
		}
		
		while(true)
		{
			if(Thread.activeCount() <= 3)
			{
				System.out.println("Runtime: "+ (System.currentTimeMillis() - start));
				break;
			}
		}
	}

}

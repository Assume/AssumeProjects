package org.assume.FileSyncer;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FileTest
{


	static List<File> files = new ArrayList<File>();
	static int spc_count=-1;
	static void Process(File aFile) {
		spc_count++;
		String spcs = "";
		for (int i = 0; i < spc_count; i++)
		{
			spcs += " ";
		}
		if(aFile.isFile())
		{
			System.out.println(spcs + "[FILE] " + aFile.getName());
		}
		else if (aFile.isDirectory()) 
		{
			System.out.println(spcs + "[DIR] " + aFile.getName());
			File[] listOfFiles = aFile.listFiles();
			if(listOfFiles != null)
			{
				for (int i = 0; i < listOfFiles.length; i++)
				{
					if(listOfFiles[i].isFile())
					{
						files.add(listOfFiles[i]);
					}
					Process(listOfFiles[i]);
				}
			}
			else 
			{
				System.out.println(spcs + " [ACCESS DENIED]");
			}
		}
		spc_count--;
	}


}

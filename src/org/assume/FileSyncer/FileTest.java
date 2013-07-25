package org.assume.FileSyncer;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

	public static void main(String[] args) throws InterruptedException {
		String nam = "C:\\Users\\Adam\\SkyDrive";
		File aFile = new File(nam);
		Process(aFile);
		
		Thread.sleep(25000);
		getFilesChanged();
	}


	
	static void getFilesChanged()
	{
		for(File f : files.toArray(new File[files.size()]))
		{
			if(isFileChanged(f))
			{
				System.out.println("Changed" + f.getAbsolutePath());
			}
		}
	}


	static boolean isFileChanged(File f)
	{
		if(!files.contains(f))
		{
			files.add(f);
			return true;
		}
		else 
		{
			return files.get(files.indexOf(f)).equals(f.getAbsoluteFile());
		}
	}
	
	static File getAllDirectories(String directory)
	{
		for(File f : new File(directory).listFiles())
		{
			if(f.isDirectory())
			{
				return f;
			}
		}
		return null;
	}


	ArrayList<File> getAllFiles(String directory)
	{

		List<File> list = new ArrayList<File>();
		List<File> directories = new ArrayList<File>();
		List<File> d2 = new ArrayList<File>();
		for(File f : new File(directory).listFiles())
		{
			if(!list.contains(f.getAbsoluteFile()) && !f.isDirectory())
			{
				list.add(f.getAbsoluteFile());
			}
			if(f.isDirectory() && !directories.contains(f.getAbsolutePath()))
			{
				directories.add(f.getAbsoluteFile());

			}
		}
		for(File f : directories.toArray(new File[directories.size()]))
		{
			if(!list.contains(f.getAbsoluteFile()) && !f.isDirectory())
			{
				list.add(f.getAbsoluteFile());
			}
		}
		return null;		
	}

}

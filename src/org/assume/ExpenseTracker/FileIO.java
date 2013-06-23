package org.assume.ExpenseTracker;

import java.io.BufferedWriter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import org.assume.api.formatting.Format;
import org.assume.api.types.Category;



public class FileIO
{

	static void output() throws IOException
	{
		try{
			FileWriter writer = new FileWriter(new File("report.txt"));
			BufferedWriter out = new BufferedWriter(writer);
			for(String d : generateReport())
			{
				out.write(d);
				out.newLine();
			}
			out.close();
			writer.close();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	private static String[] generateReport()
	{
		ArrayList<String> ar = new ArrayList<String>();

		for(Category d : Tracker.totalMap.keySet())
		{
			if(Tracker.totalMap.get(d.toString()) != 0.0)
				ar.add("You spent "+ Format.getPriceFormatted(Tracker.totalMap.get(d.toString())) + " on " + d );
		}
		return ar.toArray(new String[ar.size()]);
	}
}

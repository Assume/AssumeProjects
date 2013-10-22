package org.assume.ZybezPriceGrabber;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriterMe {

	private File file;
	private BufferedWriter writer;
	public FileWriterMe(File file) throws IOException
	{
		this.file = file;
		this.writer = new BufferedWriter(new FileWriter(this.file));
	}
	
	public void addItem(String name, int price) throws IOException
	{
		writer.newLine();
		writer.write(name + " : "+price);
	}
	
}

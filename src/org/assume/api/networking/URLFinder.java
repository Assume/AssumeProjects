package org.assume.api.networking;

import java.awt.Image;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;

import javax.imageio.ImageIO;

public class URLFinder
{
	public static String[] getFileUrls(String url, String extension) throws IOException
	{
		Collection<String> list = new ArrayList<String>();
		BufferedReader in = new BufferedReader(
				new InputStreamReader(new URL(url).openStream()));
		String line;
		while((line = in.readLine()) != null)
		{
			for(String d : line.split(" "))
			{
				if(d.contains(extension) && d.contains("http"))
				{
					list.add(d.substring(d.indexOf("http"), d.indexOf(extension)).concat(extension));
				}
			}
		}
		in.close();
		return list.toArray(new String[list.size()]);
	}

	public static Image[] getImages(String... urls) throws MalformedURLException, IOException
	{
		Collection<Image> images = new ArrayList<Image>();
		for(String d : urls)
		{
			if(d != null)
			{
				images.add(ImageIO.read(new URL(d)));
			}
		}	
		return images.toArray(new Image[images.size()]);
	}


	public static String[] getImageUrls(String url) throws IOException
	{
		Collection<String> list = new ArrayList<String>();
		BufferedReader in = new BufferedReader(
				new InputStreamReader(new URL(url).openStream()));
		String line;
		while ((line = in.readLine()) != null)
		{
			if(line.contains(".jpg") ||
					line.contains(".gif") ||
					line.contains(".jpeg") ||
					line.contains(".png") ||
					line.contains(".bmp") ||
					line.contains(".webp"))
			{
				for(String d : line.split(" "))
				{
					if(d.contains(".jpg") && d.contains("http"))
					{
						list.add(d.substring(d.indexOf("http"), d.indexOf(".jpg")).concat(".jpg"));
					}
					else if(d.contains(".gif") && d.contains("http"))
					{
						list.add(d.substring(d.indexOf("http"), d.indexOf(".gif")).concat(".gif"));
					}
					else if(d.contains(".png") && d.contains("http"))
					{
						list.add(d.substring(d.indexOf("http"), d.indexOf(".png")).concat(".png"));
					}
					else if(d.contains(".jpeg") && d.contains("http"))
					{
						list.add(d.substring(d.indexOf("http"), d.indexOf(".jpeg")).concat(".jpeg"));
					}
					else if(d.contains(".bmp") && d.contains("http"))
					{
						list.add(d.substring(line.indexOf("http"), d.indexOf(".bmp")).concat(".bmp"));
					}
					else if(d.contains(".webp") && d.contains("http"))
					{
						list.add(d.substring(d.indexOf("http"), d.indexOf(".webp")).concat(".webp"));
					}
				}
			}
		}
		in.close();
		return list.toArray(new String[list.size()]);
	}
}

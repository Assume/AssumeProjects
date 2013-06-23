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

	public static void main(String[] args) throws IOException
	{
		for(String d : getFileUrls("http://imgur.com", "jpg"))
		{
			if(d != null)
			{
				System.out.println(d.toString());
			}
		}
	}

	public static String[] getFileUrls(String url, String extension) throws IOException
	{
		Collection<String> list = new ArrayList<String>();
		BufferedReader in = new BufferedReader(
				new InputStreamReader(new URL(url).openStream()));
		String line;
		while((line = in.readLine()) != null)
		{
			if(line.contains(extension) && line.contains("http"))
			{
				if(line.contains(extension) && line.contains("http"))
				{
					list.add(line.substring(line.indexOf("http"), line.indexOf(extension)).concat(extension));
				}
			}
		}
		in.close();
		return list.toArray(new String[list.size()]);
	}

	public static Image[] getImages(String[] urls) throws MalformedURLException, IOException
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


	public static String[] getImageLinks(String url) throws IOException
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
				if(line.contains(".jpg") && line.contains("http"))
				{
					list.add(line.substring(line.indexOf("http"),line.indexOf(".jpg")).concat(".jpg"));
				}
				else if(line.contains(".gif") && line.contains("http"))
				{
					list.add(line.substring(line.indexOf("http"),line.indexOf(".gif")).concat(".gif"));
				}
				else if(line.contains(".png") && line.contains("http"))
				{
					list.add(line.substring(line.indexOf("http"),line.indexOf(".png")).concat(".png"));
				}
				else if(line.contains(".jpeg") && line.contains("http"))
				{
					list.add(line.substring(line.indexOf("http"),line.indexOf(".jpeg")).concat(".jpeg"));
				}
				else if(line.contains(".bmp") && line.contains("http"))
				{
					list.add(line.substring(line.indexOf("http"),line.indexOf(".bmp")).concat(".bmp"));
				}
				else if(line.contains(".webp") && line.contains("http"))
				{
					list.add(line.substring(line.indexOf("http"),line.indexOf(".webp")).concat(".webp"));
				}
			}
		}
		in.close();
		return list.toArray(new String[list.size()]);
	}
}

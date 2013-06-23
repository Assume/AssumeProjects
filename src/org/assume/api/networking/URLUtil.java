package org.assume.api.networking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;

public class URLUtil
{
	private String url_;
	private String extension_;

	public URLUtil(String url, String extension)
	{
		this.url_ = url;
		this.extension_ = extension;
	}

	public URLUtil(String url)
	{
		this.url_ = url;
	}


	public String[] getFileUrls() throws IOException
	{
		if(extension_ == null)
		{
			return null;
		}
		Collection<String> list = new ArrayList<String>();
		BufferedReader in = new BufferedReader(
				new InputStreamReader(new URL(url_).openStream()));
		String line;
		while((line = in.readLine()) != null)
		{
			for(String d : line.split(" "))
			{
				/* If the line of html contains the file extension that is passed it will execute the code below
				* Since a line of html could look like this http://someurlhere.com/blah/blah <src>http://someurlhere.com/image.jpg</src> 
				* You need to split at each space on the line (a url can't have a space) and check once again until you get to the end of the line
				* When it find a correctly formatted URL it creates a substring starting at http and ending at the file extension.
				* Since it will remove the file extension on the END of the url, you need to add it back after creating the substring
				* It does not remove http when creating a substring
				* It does not matter if you pass '.jpg' or 'jpg'. You can do either
				*/
				if(d.contains(extension_) && d.contains("http"))
				{
					list.add(d.substring(d.indexOf("http"), d.indexOf(extension_)).concat(extension_));
				}
			}
		}
		in.close();
		return list.toArray(new String[list.size()]);
	}


	public String[] getImageUrls() throws IOException
	{
		Collection<String> list = new ArrayList<String>();
		BufferedReader in = new BufferedReader(
				new InputStreamReader(new URL(url_).openStream()));
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
				/* If the line of html contains any of the above image file extensions it will execute the code below
				* Since a line of html could look like this http://someurlhere.com/blah/blah <src>http://someurlhere.com/image.jpg</src> 
				* You need to split at each space on the line (a url can't have a space) and check once again until you get to the end of the line
				* When it find a correctly formatted URL it creates a substring starting at http and ending at the file extension.
				* Since it will remove the file extension on the END of the url, you need to add it back after creating the substring
				* It does not remove http when creating a substring
				*/
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

package testing;

import java.io.File;

import java.io.IOException;

import org.assume.api.networking.URLUtil;
import org.assume.api.types.URLW;

public class Test
{
	public static void main(String[] args) throws IOException
	{
		long t = System.currentTimeMillis();
		for(final URLW d : new URLUtil("http://imgur.com").getImageUrls())
		{
			System.out.println(d.toString());
					System.out.println(d.download(System
							.getProperty("user.home")
							+ File.separator
							+ "Test"
							+ File.separator + d.getFileName()));
	
		}
		System.out.println(System.currentTimeMillis() - t);
	}
}

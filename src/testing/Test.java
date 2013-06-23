package testing;

import java.io.File;

import java.io.IOException;

import org.assume.api.networking.URLUtil;
import org.assume.api.types.URLW;

public class Test
{
	public static void main(String[] args) throws IOException
	{
		for(URLW d : new URLUtil("https://imgur.com").getImageUrls())
		{
			System.out.println(d.toString());
			if(d.download(System.getProperty("user.home")+
				File.separator+
				"Test"+
				File.separator+
				d.getFileName()))
			{
			System.out.println("Success");
			}
		}
	}
}

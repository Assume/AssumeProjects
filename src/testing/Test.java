package testing;

import java.io.File;

import java.io.IOException;

import org.assume.api.networking.URLUtil;
import org.assume.api.types.URLW;

public class Test
{
	public static void main(String[] args) throws IOException
	{
		int i = 0;
		for(URLW d : new URLUtil("http://imgur.com").getImageUrls())
		{
			System.out.println(d.toString());
			if(d.download(System.getProperty("user.home")+
				File.separator+
				i+".jpg"))
			{
				i++;
			}
		}
	}
}

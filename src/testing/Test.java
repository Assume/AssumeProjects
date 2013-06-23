package testing;

import java.io.IOException;

import org.assume.api.networking.URLUtil;

public class Test
{
	public static void main(String[] args) throws IOException
	{
		for(String d : new URLUtil("http://engagdet.com").getImageUrls())
		{
			System.out.println(d);
		}
	}
}

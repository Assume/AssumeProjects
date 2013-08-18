package org.assume.api.networking.files;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;

public class Download {


	/* The file name is the FULL path 
	 *  ex. System.getProperty("user.home")+
	 *		File.separator+
	 *		"Users"+
	 *		File.separator+
	 *		"Adam"+
	 *		File.separator+
	 *		"documents"+
	 *		File.separator+
	 *		"food"+
	 *		"food.png");
	 */
	public static boolean download(final String filePath, final String url)
	{
		OutputStream out = null;
		URLConnection connection = null;
		InputStream in = null;
		try
		{
			out = new BufferedOutputStream(new FileOutputStream(
					filePath));
			connection = new URL(url).openConnection();
			in = connection.getInputStream();
			byte[] buffer = new byte[1024];
			int read;
			while ((read = in.read(buffer)) != -1)
			{
				out.write(buffer, 0, read);
			}

		} catch (Exception e)
		{
			e.printStackTrace();
		} finally
		{
			try
			{
				if (in != null)
				{
					in.close();
				}
				if (out != null)
				{
					out.close();
				}
			} catch (IOException e)
			{

			}
		}

		return new File(filePath).exists();
	}
}

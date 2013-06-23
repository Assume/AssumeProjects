package org.assume.LoaderInstaller;

import java.io.BufferedOutputStream;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;

import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import net.lingala.zip4j.core.ZipFile;
import net.lingala.zip4j.exception.ZipException;

public class LoaderInstaller
{

	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException, ZipException, IOException
	{
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		downloadFile("http://sjbijzitter.info/bot/tribot/loader/downloads/Salvation's%20Script%20Loader.jar", System.getProperty("user.home")+
				File.separator+
				"AppData"+
				File.separator+
				"Roaming"+
				File.separator+
				".tribot"+
				File.separator+
				"bin"+"loader.jar");
		
		ZipFile zip = new ZipFile(System.getProperty("user.home")+
				File.separator+
				"AppData"+
				File.separator+
				"Roaming"+
				File.separator+
				".tribot"+
				File.separator+
				"bin"+"loader.jar");
		
		if(zip != null)
		{
			zip.extractAll(System.getProperty("user.home")+
					File.separator+
					"AppData"+
					File.separator+
					"Roaming"+
					File.separator+
					".tribot"+
					File.separator+
					"bin");
			
			JOptionPane.showMessageDialog(null, "Succesfully installed loader");
		}
	}


	public static void downloadFile(String link, String fileName) 
	{
		OutputStream out = null;
		URLConnection connection = null;
		InputStream in = null;
		try {
			URL url = new URL(link);
			out = new BufferedOutputStream(new FileOutputStream(fileName));
			connection = url.openConnection();
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
	}
}

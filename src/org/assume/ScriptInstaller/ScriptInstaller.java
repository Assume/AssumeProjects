package org.assume.ScriptInstaller;

import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.filechooser.FileNameExtensionFilter;

import net.lingala.zip4j.core.ZipFile;
import net.lingala.zip4j.exception.ZipException;

public class ScriptInstaller
{

	public static void main(String[] args) throws ZipException, UnsupportedLookAndFeelException, ClassNotFoundException, InstantiationException, IllegalAccessException
	{
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());//getLookAndFeel());
		final JFileChooser fc = new JFileChooser();

		ZipFile zip = null;
		fc.setFileFilter(new FileNameExtensionFilter("zip","zip"));
		fc.setFileFilter(new FileNameExtensionFilter("jar", "jar"));
		fc.setAcceptAllFileFilterUsed(false);
		String location = null;
		if(fc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)
		{
			zip = new ZipFile(fc.getSelectedFile());
		}
		switch((String) JOptionPane.showInputDialog(null, 
				"Extract to /bin or /bin/scripts",
				"Location",
				JOptionPane.QUESTION_MESSAGE, 
				null, 
				new String[]{"bin", "scripts"}, 
				"scripts"))
				{
				case "bin":
					location = System.getProperty("user.home")+
					File.separator+
					"AppData"+
					File.separator+
					"Roaming"+
					File.separator+
					".tribot"+
					File.separator+
					"bin"+"name.jar";
					break;
				case "scripts":
					location = System.getProperty("user.home")+
					File.separator+
					"AppData"+
					File.separator+
					"Roaming"+
					File.separator+
					".tribot"+
					File.separator+
					"bin"+
					File.separator+"scripts";
					break;
				}
		zip = new ZipFile(location);
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
					"bin");
		}
	}
}

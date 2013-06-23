package org.assume.api.System;

import java.io.File;
import java.util.Map;

public class SystemStats {
	
	public static String getOS()
	{
		return System.getProperty("os.name");
	}
	
	public static long getHDDSpace(String disk)
	{
		disk.toUpperCase();
		long diskSize = new File(disk+":/").getTotalSpace();
		return diskSize;
	}
	
	public static long getMemory()
	{
		return Runtime.getRuntime().maxMemory();
	}
	
	public static int getCores()
	{
		return Runtime.getRuntime().availableProcessors();
	}
	
	public static String getCPUName()
	{
		return System.getenv("PROCESSOR_IDENTIFIER");
	}
	
	public static String getHomeDirectory()
	{
		return System.getProperty("user.home");
	}
}

package org.assume.ScriptInformation.GUI;

import java.util.HashMap;
import java.util.Map;

import org.assume.ScriptInformation.client.Updater;

import scripts.*;

public class GUIHandler
{

	public static void updateScriptList(Map<String, ScriptStatus> map, String username)
	{
		String[] names = map.keySet().toArray(new String[map.size()]);
		for(String s : names)
		{
			ScriptStatus st = map.get(s);
			if(!GUI.listOfUsers.contains(st.getUsername()))
			{
				GUI.modelScripts.addElement("Script: "+
						map.get(s).getScriptName() +" | Username: ["+ 
						st.getUsername() +
						"] |" + "Status: "+
						st.getScriptStatus());
				GUI.listOfUsers.add(st.getUsername());
			}
			else if(s.toString().equals(username))
			{
				String e = getStringByUsername(st.getUsername());
				if(e != null && GUI.modelScripts.contains(e))
				{
					if(GUI.modelScripts.get(GUI.modelScripts.indexOf(e)) != null)
					{
						GUI.modelScripts.removeElement(e);
						GUI.modelScripts.addElement("Script: "+
								map.get(s).getScriptName() +" | Username: ["+ 
								st.getUsername() +
								"] |" + "Status: "+ st.getScriptStatus());
					}
				}
			}
			else{}
		}
	}

	public static String getStringByUsername(String username)
	{
		for(Object s : GUI.modelScripts.toArray())
		{
			if(s.toString().contains(username))
			{
				return s.toString();
			}
		}
		return null;
	}

	private static String getUsername(String t, String firstSplit, String secondSplit)
	{

		return t.substring(t.toString().indexOf(firstSplit), t.toString().indexOf(secondSplit)).replace(firstSplit, "");
	}

	public static void updateInfoList(String listInfo)
	{
		String username = getUsername(listInfo, "[","]");
		ScriptStatus s = Updater.map.get(username);
		GUI.modelInfo.clear();
		GUI.modelInfo.addElement("Script Name: "+s.getScriptName());
		GUI.modelInfo.addElement("Username: "+s.getUsername());
		GUI.modelInfo.addElement("Script Status: "+s.getScriptStatus());
		if(s.getInformation() != null)
		{
			for(String d : s.getInformation())
			{
				GUI.modelInfo.addElement(d);
			}
		}
	}

	public static void updateInfoList(Object[] list)
	{
		String username = null;
		for(Object d : list)
		{
			if(d.toString().contains("Username"))
			{
				username = d.toString().substring(d.toString().indexOf(":")+2, d.toString().length());
			}
		}
		if(username != null)
		{
			ScriptStatus s = Updater.map.get(username);
			GUI.modelInfo.clear();
			GUI.modelInfo.addElement("Script Name: "+s.getScriptName());
			GUI.modelInfo.addElement("Username: "+s.getUsername());
			GUI.modelInfo.addElement("Script Status: "+s.getScriptStatus());
			if(s.getInformation() != null)
			{
				for(String d : s.getInformation())
				{
					GUI.modelInfo.addElement(d);
				}
			}
		}
	}
}

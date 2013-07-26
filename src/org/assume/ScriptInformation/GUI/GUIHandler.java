package org.assume.ScriptInformation.GUI;

import java.awt.List;
import java.util.HashMap;
import java.util.Map;

import org.assume.ScriptInformation.client.Updater;

import scripts.*;

public class GUIHandler
{

	public static void refresh()
	{
		if(GUI.modelScripts.size() > 0)
		{
			Object d = GUI.scriptList.getSelectedValue();
			if(d != null)
			{
				String s = d.toString();
				if(s != null)
				{
					GUIHandler.updateInfoList(s);
				}	
			}
		}
	}

	public static void refreshScriptList(Map<String, ScriptStatus> map)
	{
		String[] names = map.keySet().toArray(new String[map.size()]);
		if(names.length > 0)
		{
			GUI.modelScripts.clear();
			for(String s : names)
			{
				ScriptStatus st = map.get(s);
				GUI.modelScripts.addElement(map.get(s).getScriptName() +" | ["+ 
						st.getUsername() +
						"] | " + 
						st.getScriptStatus());
			}
		}
	}

	public static void updateScriptList(Map<String, ScriptStatus> map, String username)
	{
		GUI.scriptList.clearSelection();
		String[] names = map.keySet().toArray(new String[map.size()]);
		for(String s : names)
		{
			ScriptStatus st = map.get(s);
			if(!GUI.listOfUsers.contains(st.getUsername()))
			{
				GUI.modelScripts.addElement(map.get(s).getScriptName() +" | ["+ 
						st.getUsername() +
						"] | " + 
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
						GUI.modelScripts.addElement(map.get(s).getScriptName() +" | ["+ 
								st.getUsername() +
								"] | " + 
								st.getScriptStatus());
					}
				}
			}
			else{}
		}
		updateInfoList(GUI.modelInfo.toArray());
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

	public static String getUsername(String t, String firstSplit, String secondSplit)
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

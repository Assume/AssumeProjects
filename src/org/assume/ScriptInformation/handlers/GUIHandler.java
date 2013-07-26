package org.assume.ScriptInformation.handlers;

import java.awt.List;
import java.util.HashMap;
import java.util.Map;

import org.assume.ScriptInformation.client.Updater;
import org.assume.ScriptInformation.gui.GUI;

import scripts.*;

public class GUIHandler
{

	public void refresh()
	{
		if(GUI.modelScripts.size() > 0)
		{
			Object d = GUI.scriptList.getSelectedValue();
			if(d != null)
			{
				String s = d.toString();
				if(s != null)
				{
					this.updateInfoList(s);
				}	
			}
		}
	}

	public void updateScriptList(Map<String, ScriptStatus> map, String username)
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
						int index = GUI.modelScripts.indexOf(e);
						GUI.modelScripts.add(index ,(map.get(s).getScriptName() +" | ["+ 
								st.getUsername() +
								"] | " + 
								st.getScriptStatus()));
						GUI.modelScripts.remove(index + 1);
						/*GUI.modelScripts.addElement(map.get(s).getScriptName() +" | ["+ 
								st.getUsername() +
								"] | " + 
								st.getScriptStatus());*/
					}
				}
			}
			else{}
		}
		updateInfoList(GUI.modelInfo.toArray());
	}

	public String getStringByUsername(String username)
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

	public String getUsername(String t)
	{

		return t.substring(t.toString().indexOf("["), t.toString().indexOf("]")).replace("[", "");
	}

	public void updateInfoList(String listInfo)
	{
		String username = this.getUsername(listInfo);
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

	public void updateInfoList(Object[] list)
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

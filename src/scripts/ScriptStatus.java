package scripts;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class ScriptStatus implements Serializable
{

	private static final long serialVersionUID = -3569524862068627088L;
	
	private Map<String, String> map = new HashMap<String, String>();
	private String scriptName;
	private String scriptStatus;
	private String[] information;
	private String username;
	public ScriptStatus()
	{
		
	}
	
	public String getScriptName()
	{
		return this.scriptName;
	}
	
	public void addInformation(String key, String value)
	{
		map.put(key, key+": "+value);
	}
	
	public void remove(String key)
	{
		map.remove(key);
		setInformation(map.values().toArray(new String[map.size()]));
	}
	
	public void updateInformation(String key, String value)
	{
		if(map.containsKey(key))
		{
			map.remove(key);
			map.put(key, key+": "+value);
		}
		setInformation(map.values().toArray(new String[map.size()]));
	}
	
	public boolean isKeyValid(String key)
	{
		return map.containsKey(key);
	}
	
	public String getInformation(String key)
	{
		return map.get(key);
	}
	
	public void refreshInformation()
	{
		this.setInformation(map.values().toArray(new String[map.size()]));
	}
	
	public String getUsername()
	{
		return this.username;
	}
	
	public String getScriptStatus()
	{
		return this.scriptStatus;
	}
	
	public String[] getInformation()
	{
		return this.information;
		
	}

	public void setScriptStatus(String status)
	{
		this.scriptStatus = status;
	}
	
	public void setScriptName(String name)
	{
		this.scriptName = name;
	}
	
	public void setInformation(String[] info)
	{
		this.information = info;
	}
	
	public void setUsername(String name)
	{
		this.username = name;
	}
}

package scripts;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class ScriptStatus implements Serializable
{

    public static void main(String[] args)
    {
	System.out.println(pas(2));

    }

  public static int pas(int rows)
  {
      if(rows == 0)
	  return 0;
      if(rows == 1)
	  return 1;
      else
	  return pas(rows - 1)+rows;
  }

    private static final long serialVersionUID = -3569524862068627088L;

    private Map<String, String> map = new HashMap<String, String>();
    private String scriptName;
    private String scriptStatus;
    private String[] information;
    private String username;

    public ScriptStatus()
    {

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

    public String getInformation(String key)
    {
	return this.map.get(key);
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

    public String getScriptName()
    {
	return this.scriptName;
    }

    public void addInformation(String key, String value)
    {
	this.map.put(key, key + ": " + value);
	this.refreshInformation();

    }

    public void remove(String key)
    {
	this.map.remove(key);
	this.refreshInformation();

    }

    public void updateInformation(String key, String value)
    {
	if (this.map.containsKey(key))
	{
	    this.map.remove(key);
	    this.map.put(key, key + ": " + value);
	}
	this.refreshInformation();
    }

    public boolean isKeyValid(String key)
    {
	return this.map.containsKey(key);
    }

    private void refreshInformation()
    {
	this.setInformation(this.map.values().toArray(
		new String[this.map.size()]));
    }

}

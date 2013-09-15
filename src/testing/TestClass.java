package testing;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestClass
{
	public static void main(String[] args) throws IOException, InterruptedException
	{
		TestClass test = new TestClass();
		String st = "You have 150m coins (151,358,456)";
		int occ = test.getOccurnceOf(st, ',');
		int tot = 0;
		Pattern c = Pattern.compile("([0-9]++)[k | m]");
		Matcher m = c.matcher(st);
		Pattern d = Pattern.compile("[,][0-9]{3}");
		Matcher t = d.matcher(st);
		while(m.find())
		{
			if(m.group().contains("k"))
			{
				tot = (Integer.parseInt(m.group().replace("k", "")) * 1000);
				while(t.find())
				{
					tot += Integer.parseInt(t.group().replace("," , ""));
				}
			}
			else if(m.group().contains("m"))
			{
				StringBuilder b = new StringBuilder();
				//b.append(m.group().replace(oldChar, newChar));
				while(t.find())
				{
					b.append(t.group().replace("," , ""));
				}
				tot = Integer.parseInt(b.toString());
			}
		}

		System.out.println(""+tot);
	}

	public int getOccurnceOf(String string, char code)
	{
		int tot = 0;
		for(char t : string.toCharArray())
		{
			if(t == code)
			{
				tot++;
			}
		}
		return tot;
	}

}

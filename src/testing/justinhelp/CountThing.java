package testing.justinhelp;

import java.util.Scanner;

public class CountThing
{

	public static void main(String[] args)
	{
		int x = new Scanner(System.in).nextInt();
		if (x >= 10)
		{
			return;
		}
		int tot = 0;
		for (int i = 1; i <= x; i++)
		{
			tot += i;
			if (i <= x - 1)
				System.out.print(i + "+");
			else
				System.out.print(i);
		}
		System.out.println("="+tot);
	}

}

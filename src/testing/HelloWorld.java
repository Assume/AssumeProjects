package testing;

import java.io.IOException;
import java.util.Random;

public class HelloWorld
{
	public static void main(String[] args) throws IOException, InterruptedException
	{
		Boolean b1 = new Boolean(true);
		Boolean b2 = new Boolean(false);

		//create another random boolean
		Boolean b3 = new Boolean(new Random().nextBoolean());
		if (!b3.equals(b1) && b3.equals(b2)) { //surely the random boolean must be true or false? This statement should never be true
		    System.out.println("huh?"); //have we discovered a new type of boolean?
		    System.out.println(b3);
		    System.out.println(b1.equals(b3));
		} else {
		    System.out.println("it's ok, nothing strange here");
		}
	}
}

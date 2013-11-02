package testing.justinhelp;

public class CountThing
{

    public static void main(String[] args)
    {
	String s = " bob[ [[ bobbb ]] ]]]]";
	System.out.println(s.replaceAll("\\[|\\]|\\s", ""));
    }

    public static double root(double number, double power)
    {
	return Math.pow(number, 1 / power);
    }

}

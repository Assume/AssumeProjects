package scripts;

public class B extends A{

public static void main(String[] args) {
	double tot = 0;
	for(int i = 1; i <=359;i++)
	{
		tot += Math.sin(i);
	}
	System.out.println(tot);
}
	
}

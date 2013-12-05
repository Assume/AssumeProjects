package org.assume.test;

public class Testing
{

    public static void main(String[] args)
    {
	System.out.println(getMaxHit(60));

    }

    public static int getMaxHit(int strLevel)
    {
	return (int) Math.ceil((5 + ((Math.floor((double) (strLevel * 1) + 8) + 3)) * (1 + (0/64))) / 10);
    }

}
